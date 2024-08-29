package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Proveedor;
import services.ProveedorService;

@WebServlet("/InsertarProveedorServlet")
public class InsertarProveedorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private ProveedorService proveedorService;

    @Override
    public void init() throws ServletException {
        super.init();
        proveedorService = new ProveedorService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombre");
        String rut = request.getParameter("rut");
        String direccion = request.getParameter("direccion");
        String correo = request.getParameter("correo");
        String telefono = request.getParameter("telefono");
        String contacto = request.getParameter("contacto");
        String telefonoContacto = request.getParameter("telefono_contacto");

        Proveedor proveedor = new Proveedor(nombre, rut, direccion, correo, telefono, contacto, telefonoContacto);

        try {
            boolean exito = proveedorService.insertarProveedor(proveedor);
            if (exito) {
                request.setAttribute("msgSuccess", "Proveedor insertado correctamente.");
            } else {
                request.setAttribute("msgError", "Error al insertar proveedor.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msgError", "Error al insertar proveedor: " + e.getMessage());
        }

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<Proveedor> proveedores = proveedorService.listarProveedores();
            request.setAttribute("proveedores", proveedores);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msgError", "Error al obtener la lista de proveedores: " + e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
