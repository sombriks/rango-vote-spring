# rango-vote-spring
sample project showcasing one or two cool technologies

- the gradle file (using gradle 2.7 from command line) have embedded tomcat
  support with datasource configured in the jndi context

- database migrations managed by flyway (because sql is good for the blood)

- jpa entities where mapped in a way that json serialization will not blow up
  because of circular references

- spring ecosystem used for transactions, security and rest-based webservices.
  CORS isn't enabled, but enabling it the rest interface bould be easily exposed

- since this approach does use atom instead eclipse (for fun, since gradle can
  enable easily it), lombok where added to avoid the tedious pale get/set novel

- those services are consumed by angular in order to provide a richer user
  experience

- angular-material where added to provide a little better look

- a few screen templates where developed, the app development used it as
  orientation, not as an rulebook. The templates can be seen in the docs folder
