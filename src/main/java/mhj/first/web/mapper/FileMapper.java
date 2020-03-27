package mhj.first.web.mapper;

import mhj.first.web.bean.History;

import java.util.List;

public interface FileMapper {

    void insertHistory(History history);

    History selectHistoryByHid(Integer hid);

    List<History> getHistories();

    void deleteFile(Integer hid);
}

