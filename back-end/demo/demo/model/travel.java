@Data
@NoArgsConstrupublic
public class Travel {

private Long id;
private String orderNumeber;
private LocalDateTime startDate;
private LocalDateTime endDate;
private BigDecimal amount;
private TravelTypeEnum type;
private List<Link> links;

public Travel(TravelTypeEnum type){
    this.type = type;

}

public void addLink(Link link) {
    if(links == null) links = new ArrayList<>();
    link.add(link);
}

}