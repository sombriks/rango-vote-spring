# rango-vote-spring
sample project showcasing one or two cool technologies

- a few screen templates where developed, the app development used it as
  orientation, not as an rulebook. The templates can be seen in the docs folder

- the gradle file (using gradle 2.7 from command line) have embedded tomcat
  support with datasource configured in the jndi context

- database migrations managed by flyway (because sql is good for the blood). The
  RDBMS used is postgresql, the user and password needed can be seen in
  build.gradle and context.xml as well

- jpa entities where mapped in a way that json serialization will not blow up
  because of circular references

- spring ecosystem used for transactions, security and rest-based webservices.
  CORS isn't enabled, but enabling it the rest interface bould be easily exposed

- since this approach does use atom instead eclipse (for fun, since gradle can
  enable easily it), lombok where added to avoid the tedious pale get/set novel

- those services are consumed by angular in order to provide a richer user
  experience

- angular-material where added to provide a little better look

- in order to get client side libraries, bower where used. using it i sped up
  the browser part of this party

# how to execute this project
to execute you'll need the following softwares available on your machine:

- jdk 8 installed and availalbe from command line

- gradle 2.7 present on system $PATH

- postgresql 9.2 or newer. the database must have the rango-vote schema created
  with username postgres and password postgres
