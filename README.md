testng-dataprovider-xstream-xml
=========================

A conceptual TestNG DataProvider using XStream to serialize XML.

RUN
===================
Run with the Maven goal:  *surefire:test *
Output is stored in *${basedir}/data*

DESIGN
===================
This framework is designed for the user to define a small number of required data columns (in this 
case there are 5) and then still be able to add a range of additional variable arguments (each defined 
with their own data type) to each test row.

TODO LIST:
=======================
1.  Finish a XML tranformer to convert test .xml data into HTML for human readability:  http://docs.oracle.com/javaee/1.4/tutorial/doc/JAXPXSLT6.html

