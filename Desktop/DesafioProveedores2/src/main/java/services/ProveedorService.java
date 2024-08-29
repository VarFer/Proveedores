package services;

import java.util.List;
import model.Proveedor;
import dao.ProveedorDAO;

public class ProveedorService {
    private ProveedorDAO proveedorDAO;

    public ProveedorService() {
        proveedorDAO = new ProveedorDAO();
    }

    public List<Proveedor> listarProveedores() {
        return proveedorDAO.listarProveedores();
    }

    public boolean insertarProveedor(Proveedor proveedor) {
        return proveedorDAO.insertarProveedor(proveedor);
    }

    public Proveedor obtenerProveedorPorId(int id) {
        return proveedorDAO.obtenerProveedorPorId(id);
    }

    public boolean actualizarProveedor(Proveedor proveedor) {
        return proveedorDAO.actualizarProveedor(proveedor);
    }

    public boolean eliminarProveedor(int id) {
        return proveedorDAO.eliminarProveedor(id);
    }
}
