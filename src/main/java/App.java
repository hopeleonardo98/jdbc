import dao.DaoBanda;
import dao.DaoGenero;
import dao.DaoIntegrante;
import dao.DataSource;
import model.Banda;
import model.Genero;
import model.Integrante;

import java.sql.SQLException;

public class App {
    public static void main(String[] args) {

        DaoGenero daoGenero = new DaoGenero(DataSource.getInstance().startSession());
        DaoBanda daoBanda = new DaoBanda(DataSource.getInstance().startSession());
        DaoIntegrante daoIntegrante = new DaoIntegrante(DataSource.getInstance().startSession());

        try {
            daoGenero.insert(new Genero("Rock", "musicas pesadas"));
//            daoGenero.update(new Genero(1, "Pagode", "Musica alegre"));
//            daoGenero.delete(new Genero(1));
//            for (Genero genero : daoGenero.select()) {
//                System.out.println(genero);
//            }
//
//            daoBanda.insert(new Banda("Nirvana", new Genero(1)));
//            daoBanda.update(new Banda(1,"Queen", new Genero(1)));
//            daoBanda.delete(new Banda(1));
//            for (Banda banda : daoBanda.select()) {
//                System.out.println(banda);
//            }
//
//            daoIntegrante.insert(new Integrante("Leonardo", "852.619.780-09", new Banda(2)));
//            daoIntegrante.update(new Integrante(1, "Joao", "107.109.870-56", new Banda(2)));
//            daoIntegrante.delete(new Integrante(1));
//            for (Integrante integrante : daoIntegrante.select()) {
//                System.out.println(integrante);
//            }
        }
        catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        finally {
            try {
                DataSource.getInstance().closeSession();
            }
            catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
    }
}
