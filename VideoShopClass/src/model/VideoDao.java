package model;

import model.vo.Video;

import java.util.ArrayList;

public interface VideoDao {
    void insertVideo(Video vo, int count) throws Exception;

	ArrayList searchVideo(int sel, String word) throws Exception;

    Video selectByPk(int vNum) throws Exception;
}
