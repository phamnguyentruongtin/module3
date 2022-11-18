import model.KhachHang;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ListCusServlet", value = "/ListCusServlet")
public class ListCusServlet extends HttpServlet {
    List<KhachHang> khachHangList;

    @Override
    public void init(ServletConfig config) throws ServletException {
        khachHangList = new ArrayList<>();
        khachHangList.add(new KhachHang("Si lùn", "24-06-1987", "Argentina", "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcR_BSXPlBjoBeJruSaCamv7kQuMNjoIIWX0CITXUVoapFCbRM9g"));
        khachHangList.add(new KhachHang("Bảy Đỉ", "05-02-1985", "Portugal", "https://nld.mediacdn.vn/291774122806476800/2022/7/26/hinh-3-16588045625731888728193.jpeg"));
        khachHangList.add(new KhachHang("Hà Duy Kiên", "28-07-1993", "England", "https://assets.goal.com/v3/assets/bltcc7a7ffd2fbf71f5/bltf03ddd2c5c470db5/60e52af2d731072d7c81bae2/13eaf87d681edfee4281ba4b1882b8d23fff5ca0.jpg"));
        khachHangList.add(new KhachHang("Em Ba Bê", "20-12-1998", "France", "https://znews-photo.zingcdn.me/w660/Uploaded/wobjcak/2022_10_29/mbap.jpeg"));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        request.setAttribute("KhachHangList", khachHangList);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
