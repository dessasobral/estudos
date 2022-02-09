@Service
public class TravelService {

    private TravelFactory factory;
    private List<Travel> travels;

    public void createTravelFactory() {
        if(factory==null) {
            factory = new TravelFactoryImpl()
        }
    
}

public void createTravelList() {
    if(travel == null) {
        travels = new ArrayList<>();

    }
}

public boolean isJSONValid(String jsonInString){
    try{
        return new ObjectMapper().readTree(jsonInString) != null;
    } cath (IOException e){
        return false;

    }
}

private long parseId(JSONObject travel){
    return Long.valueOf((int) travel.get("id"));

}

private BigDecimal parseAmout(JSONObject traval) {
    return new BigDecimal ((String) travel.get("amount"));

}

private LocalDateTime parseStartDate(JSONObject travel) {
    var startDate = (String) travel.get("startDate");
    return ZonedDateTime.parse(startDate).toLocalDateTime();

}

private LocalDateTime parseEndDate (JSONObject travel) {
    var endDate = (String) travel.get("endDate");
    return ZonedDateTime.parse(endDate).toLocalDateTime();

}

public boolean isStartDateGreaterTranEndDate(Travel travel){
    if (travel.getEndDate() == null) return false;
    return travel.getStartDate().isAfter(travel.getEndDate());

}

private void setTravelValues(JSONObject jsonTravel, Travel travel){
    String orderNumber = (String) jsonTravel.get("orderNumber");
    String type = (String) jsonTravel.get("type");

    travel.setOrderNumber(orderNumber != null ? orderNumber : travel.getOrderNumber());
		travel.setAmount(jsonTravel.get("amount") != null ? parseAmount(jsonTravel) : travel.getAmount());
		travel.setStartDate(jsonTravel.get("initialDate") != null ? parseStartDate(jsonTravel) : travel.getStartDate());
		travel.setEndDate(jsonTravel.get("finalDate") != null ? parseEndDate(jsonTravel) : travel.getEndDate());
		travel.setType(type != null ? TravelTypeEnum.getEnum(type) : travel.getType());
}
public Travel create(JSONObject jsonTravel) {
		
    createFactory();
    
    Travel travel = factory.createTravel((String) jsonTravel.get("type"));
    travel.setId(parseId(jsonTravel));
    setTravelValues(jsonTravel, travel);
    
    return travel;
}

public Travel update(Travel travel, JSONObject jsonTravel) {
    
    setTravelValues(jsonTravel, travel);
    return travel;
}

public void add(Travel travel) {
    createTravelList();
    travels.add(travel);
}
public List<Travel> find() {
    createTravelList();