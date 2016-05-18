#/usr/bin/python
import os
from marionette import Marionette
os.system("firefox -marionette &")
cl = Marionette('localhost', port=2828)
cl.start_session()
cl.navigate("http://google.com")
