package org.q10viking.dao;
import java.util.List;

import org.q10viking.beans.NewsLabel;
public interface INewsLabelDao {
	NewsLabel selectParentByParentId(int pid);
}
