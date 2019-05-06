#some python libraries that we'll be using
import re, string, calendar
from wikipedia import page
from bs4 import BeautifulSoup

#some python functions to get and clean the text for us
def get_page_html(title):
	return page(title).html()

def get_first_infobox_text(title):
	html = get_page_html(title)
	return clean_text(get_first_infobox(html).text)

def get_first_infobox(html):
	soup = BeautifulSoup(html, 'html.parser')
	results = soup.find_all(class_ = 'infobox')

	if not results:
		raise LookupError('Page has no infobox')

	return results[0]

def clean_text(text):
	only_ascii = ''.join([char if char in string.printable else ' ' for char in text])
	no_dup_spaces = re.sub(' +', ' ', only_ascii)
	no_dup_newlines = re.sub('\n+', '\n', no_dup_spaces)
	return no_dup_newlines

def get_match(text, pattern, error_text = "Page doesn't appear to have the property you're expecting"):
	p = re.compile(pattern, re.DOTALL | re.IGNORECASE)
	match = p.search(text)

	if not match:
		raise AttributeError(error_text)

	return match

def get_planet_radius(title):
	#infobox_text = get_first_infobox_text(title)
	print(infobox_text)
	pattern = "(?P<text>Polar radius|Polar radius[\s])(?P<radius>[\d]+\.[\d]+|[\d]+,[\d]+)"
	error_text = "Page infobox has no polar radius information."
	match = get_match(infobox_text, pattern, error_text)
	print(match.groups())

	radius = match.group("radius")
	return radius

#examples
print(get_planet_radius("Mars")) #should print 3,376.2
print(get_planet_radius("Earth")) #should print 6356.8
print(get_planet_radius("Jupiter")) #should print 66,854
print(get_planet_radius("Saturn")) #should print 54,364

def get_birth_date(title):
    #infobox_text = get_first_infobox_text(title)
    print(infobox_text)
    pattern = "(?P<birth>[\d]+\-[\d]+\-[\d]+)"
    error_text = "Page infobox has no birth information. At least none in xxxx-xx-xx format"
    match = get_match(infobox_text, pattern, error_text)
    birth = match.group('birth')
    return birth

#examples
print(get_birth_date("Barack Obama")) #should print 1961-08-04
print(get_birth_date("Katy Perry")) #should print 1984-10-25
print(get_birth_date("Lebron James")) #should print 1984-12-30
print(get_birth_date("Jane Goodall")) #should print 1934-04-03
