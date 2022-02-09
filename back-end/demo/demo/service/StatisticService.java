@Service
public class StatisticService{
        public Statistic create(List<Traval> travels) {
            
            var statistics = new Statistic();
            statistics.setCount(travels.steam().count());
            
        }
}