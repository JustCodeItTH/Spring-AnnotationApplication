import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

class Start {
    public static void main (String[] data) {
        ApplicationContext context;
        context = new AnnotationConfigApplicationContext(Prepare.class);
        Package p = context.getBean(Package.class);
        System.out.println( p.carrier.getName() );
    }
}
class Prepare {
    @Bean Package first(@Qualifier("kerryExpress") Carrier c) {
        Package p = new Package();
        p.receiver = "Mr. James, 123 ....";
        p.setCarrier(c);
        return p;
    }
    
    @Bean Carrier thailandPost() { 
        Carrier c = new Carrier(); c.setName("Thailand Post"); return c; }
    @Bean Carrier kerryExpress() { 
        Carrier c = new Carrier(); c.setName("Kerry Express"); return c; }
}

class Package {
    String receiver;
    String sender = "Rabbit Shop";
    Carrier carrier;
    
    public void setReceiver(String r) {
        receiver = r;
    }
    public void setCarrier(Carrier c) {
        carrier = c;
    }
}

class Carrier {
    String name;
    public void setName(String s) {
        name = s;
    }
    public String getName() {
        return name;
    }
}





class Setup { 
    @Bean
    Team first() {
        Team t = new Team();
        t.setName("Real Madrid");
        t.point = 15;
        return t;
    }
    @Bean
    Team second() {
        Team t = new Team();
        t.setName("Barcelona");
        t.point = 12;
        return t;
    }
}
class Team {
    String name;
    int point;  
    
    public void setName(String s) {
        name = s;
    }
}
    

