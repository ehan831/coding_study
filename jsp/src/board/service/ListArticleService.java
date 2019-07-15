package board.service;

import java.util.List;

import board.model.BoardDao;
import board.model.BoardException;
import board.model.BoardRec;

public class ListArticleService {
    private static ListArticleService instance;

    private static int CountPerPage; // 전체 레코드 수
    private static int totalPageCount; // 전체 레코드 수
    private static int countPerPage = 5; // 페이지당 레코드 수

    public static ListArticleService getInstance() throws BoardException {
        if (instance == null) {
            instance = new ListArticleService( );
        }
        return instance;
    }

//    public List<BoardRec> getArticleList() throws BoardException {
//        //
//        List<BoardRec> mList = BoardDao.getInstance( ).selectList( );
//        return mList;
//    }

    public List<BoardRec> getArticleList( String pNum ) throws BoardException {
        int pageNo = 1; // pNum 이 값이 들어오기 전에는 1을 디폴트로 주고 싶어서
        if (pNum != null) {
            pageNo = Integer.parseInt( pNum );
        }
        int endRow = pageNo * countPerPage;
        int firstRow = endRow - (countPerPage - 1);
        // 전체 레코드를 검색해 온다면
        List<BoardRec> mList = BoardDao.getInstance( ).selectList( firstRow, endRow );
        return mList;
    }

    public int getTotalCount() throws BoardException {
        totalPageCount = BoardDao.getInstance().getTotalCount();

        if (totalPageCount%countPerPage == 0) {
            CountPerPage = (totalPageCount / countPerPage);
        } else {
            CountPerPage = (totalPageCount / countPerPage);
            CountPerPage ++;
        }
        return CountPerPage;
    }

}
