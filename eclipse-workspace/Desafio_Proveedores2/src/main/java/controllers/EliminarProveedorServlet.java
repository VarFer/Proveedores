package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import services.ProveedorService;

@WebServlet("/EliminarProveedorServlet")
public class EliminarProveedorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProveedorService proveedorService;

    @Override
    public void init() throws ServletException {
        super.init();
        proveedorService = new ProveedorService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            boolean exito = proveedorService.eliminarProveedor(id);
            if (exito) {
                request.setAttribute("msgSuccess", "Proveedor eliminado correctamente.");
            } else {
                request.setAttribute("msgError", "Error al eliminar proveedor.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msgError", "Error al eliminar proveedor: " + e.getMessage());
        }

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
