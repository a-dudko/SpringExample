package by.bsu.fpmi;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.bsu.fpmi.additionallibs.TagsParser;
import by.bsu.fpmi.domain.*;

public class RegistrationServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Profile profile = new Profile();
		
		String login = request.getParameter("userLogin");
		String age = request.getParameter("age");
		
		profile.setAge(Integer.parseInt(age));
		
		String tags = request.getParameter("desc");
		TagsParser tagsParser = TagsParser.getInstance();
		
	}
}
