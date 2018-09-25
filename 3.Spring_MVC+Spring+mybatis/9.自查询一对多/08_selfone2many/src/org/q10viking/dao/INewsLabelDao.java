package org.q10viking.dao;
import java.util.List;

import org.q10viking.beans.NewsLabel;
public interface INewsLabelDao {
	List<NewsLabel> selectChildrenByParentId(int pid);
	List<NewsLabel> selectNewsLabelById(int id);
}
