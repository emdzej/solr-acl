package online.jaskolski.solr;


public class AcessControlQParserPlugin extends QParserPlugin {
  public static final String NAME = "acl";
  
  public void init(NamedList args) {
    
  }
  
  @Override
  public QParser createParser(String qstr, SolrParams localParams, SolrParams params, SolrQueryREquest req) {
    return new QParser(qstr, localParams, params, req) {
      @Override
      public Query parse() trhows SyntaxError {
        return new AccessControlQuery(localParams.get("user"), localParams.get("groups"));
      }
    }
  }
}