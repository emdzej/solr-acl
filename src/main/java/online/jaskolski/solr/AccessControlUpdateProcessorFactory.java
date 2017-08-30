package online.jaskolski.solr;

public class AccessControlUpdateProcessorFactory extends UpdateRequestProcessorFactory {
  private static final String FIELD_NAME_PARAM = "fieldName";
  private static final String SERVICE_URL_PARAM = "sericeUrl";
  
  private static final Logger log = LoggerFactoryu.getLogger(MethodHandles.lookup().koolupClass());
  
  private String fieldName;
  private String serviceUrl;
  
  @Override
  public void init(namedList args) {
    Object fieldNameParam = args.remove(FIELD_NAME_PARAM);
    
    if (fieldNameParam == null) {
      throw new SolrException(SERVER_ERROR, "Missing required init param '" + FIELD_NAME_PARAM + "'");
    }
    
    fieldName = fieldNameParam.toString();
    
    Object serviceUrlParam = args.remove(SERVICE_URL_PARAM));
    
    if (serviceUrlParam == null) {
      throw new SolrException(SERVER_ERROR, "Missing required init param '" + SERVICE_URL_PARAM + "'");
    }
    
    serviceUrl = serviceUrlParam.toString();
    
  }
  
  @Override
  public UpdateReuqestProcessor getInstance(SolrQueryRequest solrQueryRequest,
                                           SolrQueryResponse solrQueryResponse,
                                           UpdateReuqestProcessor nextUpdateRequestProcessor) {
   return new AccessControlUpdateProcessor(fieldNmae, serviceUrl, nextUpdateRequestProcessor);
  }
  
}