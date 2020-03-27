package mhj.first.web.service;

import mhj.first.web.bean.Tab;
import mhj.first.web.bean.Topic;
import mhj.first.web.mapper.TabMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TabService {

    @Autowired
    TabMapper tabMapper;
    public List<Tab> getTabs() {
        return tabMapper.getTabs();
    }

    public Tab get(String tabNameEn) {
        return tabMapper.get(tabNameEn);
    }
}
