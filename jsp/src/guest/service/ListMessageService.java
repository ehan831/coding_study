package guest.service;

import guest.model.Message;
import guest.model.MessageDao;
import guest.model.MessageException;

import java.util.List;

public class ListMessageService {

    //-------------------------------------------------------------------
    private int totalRecCount;        // 전체 레코드 수
    private int pageTotalCount;        // 전체 페이지 수
    private int countPerPage = 3;    // 한페이지당 레코드 수

    private static ListMessageService instance;

    public static ListMessageService getInstance() throws MessageException {
        if (instance == null) {
            instance = new ListMessageService( );
        }
        return instance;
    }

    private ListMessageService() {

    }

    public List<Message> getMessageList() throws MessageException {
        // 전체 레코드를 검색해 온다면
        List<guest.model.Message> mList = MessageDao.getInstance( ).selectList( );
        return mList;
    }

    public List<Message> getMessageList(String pNum) throws MessageException {
        // 페이지 번호에 따른 레코드 번호 추출
        // 1페이지 : 1~3
        // 2페이지 : 4~6 ..계속
        int pageNo = 1; // pNum 이 값이 들어오기 전에는 1을 디폴트로 주고 싶어서
        if (pNum != null) {
            pageNo = Integer.parseInt( pNum );
        }
        int endRow = pageNo * countPerPage;
        int firstRow = endRow - (countPerPage - 1);
        // 전체 레코드를 검색해 온다면
        List<guest.model.Message> mList = MessageDao.getInstance( ).selectList( firstRow, endRow );
        return mList;
    }

    public int getTotalPage() throws MessageException {

        // 전체 레코드 수를 얻어옴
        totalRecCount = MessageDao.getInstance( ).getTotalCount( );

        // 전체 페이지 수를 구함
        // 레코드 수 | 페이지 수
        // 9 | 3
        // 10 | 4
        // 12 | 4
        // 13 | 5 페이지
        if (totalRecCount%countPerPage == 0) {
            pageTotalCount = (totalRecCount / countPerPage);
        } else {
            pageTotalCount = (totalRecCount / countPerPage);
            pageTotalCount ++;
        }
        return pageTotalCount;

    }
}
