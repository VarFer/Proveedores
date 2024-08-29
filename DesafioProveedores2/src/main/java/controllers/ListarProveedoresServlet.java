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

@WebServlet("/ListarProveedoresServlet")
public class ListarProveedoresServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProveedorService proveedorService;

    @Override
    public void init() throws ServletException {
        super.init();
        proveedorService = new ProveedorService();
    }

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
