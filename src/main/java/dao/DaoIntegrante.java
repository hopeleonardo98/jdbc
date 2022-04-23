package dao;

import model.Banda;
import model.Genero;
import model.Integrante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoIntegrante {
    private Connection connection;

    public DaoIntegrante(Connection connection) {
        this.connection = connection;
    }

    public void insert(Integrante integrante) throws SQLException {
        final String SQL = "INSERT INTO Integrante (nome, cpf, fkBanda) VALUES (?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setString(1, integrante.getNome());
        preparedStatement.setString(2, integrante.getCpf());
        preparedStatement.setInt(3, integrante.getBanda().getId());
        preparedStatement.executeUpdate();
    }

    public void update(Integrante integrante) throws SQLException {
        final String SQL = "UPDATE Integrante SET nome = ?, cpf = ?, fkBanda = ? WHERE id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setString(1, integrante.getNome());
        preparedStatement.setString(2, integrante.getCpf());
        preparedStatement.setInt(3, integrante.getBanda().getId());
        preparedStatement.setInt(4, integrante.getId());
        preparedStatement.executeUpdate();
    }

    public void delete(Integrante integrante) throws SQLException {
        final String SQL = "DELETE FROM Integrante WHERE id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setInt(1,integrante.getId());
        preparedStatement.executeUpdate();
    }

    public List<Integrante> select() throws SQLException {
        final String SQL = "SELECT Banda.nome as Banda, Genero.nome as Genero, Integrante.nome as Integrante " +
                "FROM Banda " +
                "INNER JOIN Genero ON Genero.id = Banda.fkGenero " +
                "INNER JOIN Integrante ON Banda.id = Integrante.fkBanda";

        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Integrante> integranteList = new ArrayList<>();

        while (resultSet.next()) {
            Genero genero = new Genero();
            genero.setNome(resultSet.getString("Genero"));

            Banda banda = new Banda();
            banda.setNome(resultSet.getString("Banda"));
            banda.setGenero(genero);

            Integrante integrante = new Integrante();
            integrante.setNome(resultSet.getString("Integrante"));
            integrante.setBanda(banda);

            integranteList.add(integrante);
        }
        return integranteList;
    }
}
