package mhj.first.web.mapper;

import mhj.first.web.bean.Tab;
import mhj.first.web.bean.Topic;

import java.util.List;

public interface TabMapper {
    List<Tab> getTabs();

    Tab get(String tabNameEn);
}
