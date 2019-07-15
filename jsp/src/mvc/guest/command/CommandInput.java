package mvc.guest.command;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import guest.service.ListMessageService;
import mvc.guest.model.Message;
import mvc.guest.model.MessageDao;
import mvc.guest.model.MessageException;

public class CommandInput implements Command {
	private String next;

	public CommandInput( String _next ){
		next = _next;
	}
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response  ) throws CommandException {
		try{

			Message msg = new Message();
			msg.setGuestName( request.getParameter("guestName"));
			msg.setPassword(request.getParameter("password"));
			msg.setMessage( request.getParameter("message"));

			MessageDao dao = MessageDao.getInstance();
			dao.insert(msg);

			// 위에는 입력 관련, 밑에는 검색 관련
			List <Message> mList = dao.selectList();
			request.setAttribute("param", mList );

		}catch( MessageException ex ){
			throw new CommandException("CommandInput.java < 입력시 > " + ex.toString() ); 
		}
		return next;
	}

}
