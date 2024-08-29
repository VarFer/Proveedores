package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Proveedor;
import util.DataBaseConnection;

public class ProveedorDAO {
    private Connection connection;

    public ProveedorDAO() {
        connection = DataBaseConnection.getInstance().getConnection();
    }

    public boolean insertarProveedor(Proveedor proveedor) {
        String sql = "INSERT INTO proveedores (nombre, rut, direccion, correo, telefono, contacto, telefono_contacto) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, proveedor.getNombre());
            ps.setString(2, proveedor.getRut());
            ps.setString(3, proveedor.getDireccion());
            ps.setString(4, proveedor.getCorreo());
            ps.setString(5, proveedor.getTelefono());
            ps.setString(6, proveedor.getContacto());
            ps.setString(7, proveedor.getTelefonoContacto());
            int result = ps.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Proveedor> listarProveedores() {
        List<Proveedor> proveedores = new ArrayList<>();
        String sql = "SELECT * FROM proveedores";
        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Proveedor proveedor = mapResultSetToProveedor(rs);
                proveedores.add(proveedor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proveedores;
    }

    public Proveedor obtenerProveedorPorId(int id) {
        Proveedor proveedor = null;
        String sql = "SELECT * FROM proveedores WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    proveedor = mapResultSetToProveedor(rs);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return proveedor;
    }

    public boolean actualizarProveedor(Proveedor proveedor) {
        String sql = "UPDATE proveedores SET nombre = ?, rut = ?, direccion = ?, correo = ?, telefono = ?, contacto = ?, telefono_contacto = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, proveedor.getNombre());
            ps.setString(2, proveedor.getRut());
            ps.setString(3, proveedor.getDireccion());
            ps.setString(4, proveedor.getCorreo());
            ps.setString(5, proveedor.getTelefono());
            ps.setString(6, proveedor.getContacto());
            ps.setString(7, proveedor.getTelefonoContacto());
            ps.setInt(8, proveedor.getId());
            int result = ps.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminarProveedor(int id) {
        String sql = "DELETE FROM proveedores WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            int result = ps.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private Proveedor mapResultSetToProveedor(ResultSet rs) throws SQLException {
        Proveedor proveedor = new Proveedor();
        proveedor.setId(rs.getInt("id"));
        proveedor.setNombre(rs.getString("nombre"));
        proveedor.setRut(rs.getString("rut"));
        proveedor.setDireccion(rs.getString("direccion"));
        proveedor.setCorreo(rs.getString("correo"));
        proveedor.setTelefono(rs.getString("telefono"));
        proveedor.setContacto(rs.getString("contacto"));
        proveedor.setTelefonoContacto(rs.getString("telefono_contacto"));
        return proveedor;
    }
}
