package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Proveedor;
import services.ProveedorService;

@WebServlet("/EditarProveedorServlet")
public class EditarProveedorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProveedorService proveedorService;

    @Override
    public void init() throws ServletException {
        super.init();
        proveedorService = new ProveedorService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            Proveedor proveedor = proveedorService.obtenerProveedorPorId(id);
            request.setAttribute("proveedor", proveedor);
            request.getRequestDispatcher("edicion.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msgError", "Error al obtener el proveedor: " + e.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }
}
