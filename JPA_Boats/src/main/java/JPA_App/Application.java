package JPA_App;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory(
                        "JPA_Boats");
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            //String sql = String.format("INSERT INTO products (name,cost) VALUES('%s',%s);",product.getName(), product.getCost());
            Vessel boat1 = new Vessel(1, "Fishy Business", "LA-2791-GM", "motorboat", 80, "2007-11-16");
            Vessel boat2 = new Vessel(2, "The Codfather", "HHJ98986LLKJ", "trawler", 450, "2020-03-21");
            System.out.println(boat1 + boat2.toString());
            em.merge(boat1);
            em.merge(boat2);
            em.getTransaction().commit();
            List<Vessel> boats = em.createQuery("Select p from Vessel p", Vessel.class).getResultList();
            boats.forEach(System.out::println);

        }
        finally {
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
        }

        em.close();
        emf.close();
    }


}
