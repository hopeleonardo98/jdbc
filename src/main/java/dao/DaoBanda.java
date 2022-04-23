package dao;

import model.Banda;
import model.Genero;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoBanda {
    private final Connection connection;

    public DaoBanda(Connection connection) {
        this.connection = connection;
    }

    public void insert(Banda banda) throws SQLException {
        final String SQL = "INSERT INTO Banda (nome, fkGenero) VALUES (?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setString(1, banda.getNome());
        preparedStatement.setInt(2, banda.getGenero().getId());
        preparedStatement.executeUpdate();
    }

    public void update(Banda banda) throws SQLException {
        final String SQL = "UPDATE Banda SET nome = ?, fkGenero = ? WHERE id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setString(1, banda.getNome());
        preparedStatement.setInt(2, banda.getGenero().getId());
        preparedStatement.setInt(3, banda.getId());
        preparedStatement.executeUpdate();
    }

    public void delete(Banda banda) throws SQLException {
        final String SQL = "DELETE FROM Banda WHERE id = ?";

        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        preparedStatement.setInt(1, banda.getId());
        preparedStatement.executeUpdate();
    }

    public List<Banda> select() throws SQLException {
        final String SQL = "SELECT Banda.nome as Banda, Genero.nome as Genero " +
                "FROM Banda " +
                "INNER JOIN Genero ON Genero.id = Banda.fkGenero";

        PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Banda> bandaList = new ArrayList<>();

        while (resultSet.next()) {
            Genero genero = new Genero();
            genero.setNome(resultSet.getString("Genero"));

            Banda banda = new Banda();
            banda.setNome(resultSet.getString("Banda"));
            banda.setGenero(genero);

            bandaList.add(banda);
        }
        return bandaList;
    }
}
