import re, string, calendar
from wikipedia import page
import wikipedia
from bs4 import BeautifulSoup
from nltk import word_tokenize, pos_tag, ne_chunk
from nltk.tree import Tree
from match import match
from typing import List, Callable, Tuple, Any, Match

def get_page_html(title: str) -> str:
    """Gets html of a wikipedia page

    Args:
        title - title of the page

    Returns:
        html of the page
    """
    return page(title).html()

def get_first_infobox_text(html: str) -> str:
    """Gets first infobox html from a Wikipedia page (summary box)

    Args:
        html - the full html of the page

    Returns:
        html of just the first infobox
    """
    soup = BeautifulSoup(html, 'html.parser')
    results = soup.find_all(class_ = 'infobox')

    if not results: raise LookupError('Page has no infobox')
    return results[0].text

def clean_text(text: str) -> str:
    """Cleans given text removing non-ASCII characters and duplicate spaces & newlines

    Args:
        text - text to clean

    Returns:
        cleaned text
    """
    only_ascii = ''.join([char if char in string.printable else ' ' for char in text])
    no_dup_spaces = re.sub(' +', ' ', only_ascii)
    no_dup_newlines = re.sub('\n+', '\n', no_dup_spaces)
    return no_dup_newlines

def get_match(text: str, pattern: str,
	error_text: str = "Page doesn't appear to have the property you're expecting") -> Match:
    """Finds regex matches for a pattern

    Args:
        text - text to search within
        pattern - pattern to attempt to find within text
        error_text - text to display if pattern fails to match

    Returns:
        text that matches
    """
    p = re.compile(pattern, re.DOTALL)
    match = p.search(text)

    if not match: raise AttributeError(error_text)
    return match

def get_polar_radius(planet_name: str) -> str:
    """Gets the radius of the given planet

    Args:
        planet_name - name of the planet to get radius of

    Returns:
        radius of the given planet
    """
    infobox_text = clean_text(get_first_infobox_text(get_page_html(planet_name)))
    pattern = r'(?:Polar radius.*?)(?: ?[\d]+ )?(?P<radius>[\d,.]+)(?:.*?)km'
    error_text = "Page infobox has no polar radius information"
    match = get_match(infobox_text, pattern, error_text)

    return match.group('radius')

def get_birth_date(name: str) -> str:
    """Gets birth date of the given person

    Args:
        name - name of the person

    Returns:
        birth date of the given person
    """
    infobox_text = clean_text(get_first_infobox_text(get_page_html(name)))
    pattern = r'(?:Born\D*)(?P<birth>\d{4}-\d{2}-\d{2})'
    error_text = ("Page infobox has no birth information (to be more specific"
        " none in xxxx-xx-xx format)")
    match = get_match(infobox_text, pattern, error_text)

    return match.group('birth')

def get_capital(country: str) -> str:
	"""Gets the capital of the given country

    Args:
        country - name of the country to get capital of

    Returns:
        capital of country
    """
	infobox_text = clean_text(get_first_infobox_text(get_page_html(country)))
	pattern = r'Capital(?P<capital>[a-zA-Z]+)'
	error_text = "Page infobox has capital information"
	match = get_match(infobox_text, pattern, error_text)

	return match.group('capital')

def get_author(book: str) -> str:
	"""Gets the author of a book

    Args:
        book - name of book to get author of

    Returns:
        author of book
    """
	infobox_text = clean_text(get_first_infobox_text(get_page_html(book)))
	pattern = r'Author(?P<author>[a-zA-Z. ]+)Country'
	error_text = "Page infobox has author information"
	match = get_match(infobox_text, pattern, error_text)

	return match.group('author')

def get_demonym(place: str) -> str:
	"""Gets the demonym for people from a place

    Args:
        place - place to get demonym from

    Returns:
        demonym from place
    """
	infobox_text = clean_text(get_first_infobox_text(get_page_html(place)))
	pattern = r'Demonym\(s\)(?P<demonym>[A-Z][a-z]+)'
	error_text = "Page infobox has no demonym information"
	match = get_match(infobox_text, pattern, error_text)

	return match.group('demonym')

# below are a set of actions.  Each takes a list argument and returns
# a list of answers according to the action and the argument.
# It is important that each function returns a list of the answer(s)
# and not just the answer itself.

def birth_date(matches: List[str]) -> List[str]:
    """Returns birth date of named person in matches

    Args:
        matches - match from pattern of person's name to find birth date of

    Returns:
        birth date of named person
    """
    return [get_birth_date(' '.join(matches))]

def polar_radius(matches: List[str]) -> List[str]:
    """Returns polar radius of planet in matches

    Args:
        matches - match from pattern of planet to find polar radius of

    Returns:
        polar radius of planet
    """
    return [get_polar_radius(matches[0])]

def capital(matches: List[str]) -> List[str]:
    """Returns the capital of a country in matches

    Args:
        matches - match from pattern of country to find capital of

    Returns:
        capital of country
    """
    return [get_capital(matches[0])]

def author(matches: List[str]) -> List[str]:
    """Returns the author of a book in matches

    Args:
        matches - match from pattern of book to find author of

    Returns:
        author of book
    """
    return [get_author(matches[0])]

def demonym(matches: List[str]) -> List[str]:
    """Returns the demonym for people from a place in matches

    Args:
        matches - match from pattern of place to find demonym from

    Returns:
        demonym from place
    """
    return [get_demonym(matches[0])]


# dummy argument is ignored and doesn't matter
def bye_action(dummy: List[str]) -> None: raise KeyboardInterrupt

# type aliases to make pa_list type more readable, could also have written:
# pa_list: List[Tuple[List[str], Callable[[List[str]], List[Any]]]] = [...]
Pattern = List[str]
Action = Callable[[List[str]], List[Any]]

#  The pattern-action list for the natural language query system.
#  It must be declared here, after all of the function definitions
pa_list: List[Tuple[Pattern, Action]] = [
    ('when was % born'.split(),                 birth_date),
    ('what is the polar radius of %'.split(),   polar_radius),
	('what is the capital of %'.split(), 		capital),
	('who wrote %'.split(), 					author),
	('who is the author of %'.split(), 			author),
	('what do you call people from %'.split(), 	demonym),
	('what are people from % called'.split(),	demonym),
    (['bye'],                                   bye_action)
]

def search_pa_list(src: List[str]) -> List[str]:
    """Takes source, finds matching pattern and calls corresponding action. If
    it finds a match but has no answers it returns ["No answers"]. If it finds
    no match it returns ["I don't understand"].

    Args:
        source - a phrase represented as a list of words (strings)

    Returns:
        a list of answers. Will be ["I don't understand"] if it finds no matches
        and ["No answers"] if it finds a match but no answers
    """
    for pat, act in pa_list:
        mat = match(pat, src)
        if mat is not None:
            answer = act(mat)
            return answer if answer else ["No answers"]

    return ["I don't understand"]

def query_loop() -> None:
    """The simple query loop. The try/except structure is to catch Ctrl-C or
    Ctrl-D characters and exit gracefully"""
    print("Welcome to the Wikipedia chatbot!\n")
    while True:
        try:
            print()
            query = input("Your query? ").replace("?", "").lower().split()
            answers = search_pa_list(query)
            for ans in answers: print(ans)

        except (KeyboardInterrupt,EOFError):
            break

    print("\nSo long!\n")

# uncomment the following line once you've written all of your code and are
# ready to try it out
query_loop()


# Sample Transcript
# Welcome to the Wikipedia chatbot!


# Your query? when was Obama born
# 1961-08-04

# Your query? what is the polar radius of mars
# 3376.2

# Your query? who wrote Harry Potter
# J. K. Rowling

# Your query? who is the author of the lord of the rings
# J. R. R. Tolkien


# Your query? what do you call people from chicago
# Chicagoan

# Your query? what are people from the netherlands called
# Dutch

# Your query? bye

# So long!
