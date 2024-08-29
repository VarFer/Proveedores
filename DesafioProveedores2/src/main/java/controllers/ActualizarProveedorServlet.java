package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Proveedor;
import services.ProveedorService;

@WebServlet("/ActualizarProveedorServlet")
public class ActualizarProveedorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProveedorService proveedorService;

    @Override
    public void init() throws ServletException {
        super.init();
        proveedorService = new ProveedorService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            // Obtener los datos del formulario
            int id = Integer.parseInt(request.getParameter("id"));
            String nombre = request.getParameter("nombre");
            String rut = request.getParameter("rut");
            String direccion = request.getParameter("direccion");
            String correo = request.getParameter("correo");
            String telefono = request.getParameter("telefono");
            String contacto = request.getParameter("contacto");
            String telefonoContacto = request.getParameter("telefono_contacto");

            // Crear un objeto Proveedor con los datos obtenidos
            Proveedor proveedor = new Proveedor();
            proveedor.setId(id);
            proveedor.setNombre(nombre);
            proveedor.setRut(rut);
            proveedor.setDireccion(direccion);
            proveedor.setCorreo(correo);
            proveedor.setTelefono(telefono);
            proveedor.setContacto(contacto);
            proveedor.setTelefonoContacto(telefonoContacto);

            // Llamar al servicio para actualizar el proveedor
            boolean exito = proveedorService.actualizarProveedor(proveedor);

            if (exito) {
                // Redirigir a la lista de proveedores con un mensaje de éxito
                request.setAttribute("msgSuccess", "Proveedor actualizado correctamente.");
                response.sendRedirect("ListarProveedoresServlet");
            } else {
                // Mostrar un mensaje de error
                request.setAttribute("msgError", "No se pudo actualizar el proveedor.");
                request.getRequestDispatcher("edicion.jsp").forward(request, response);
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msgError", "Error al actualizar el proveedor: " + e.getMessage());
            request.getRequestDispatcher("edicion.jsp").forward(request, response);
        }
    }
}
