package org.q10viking.beans;
import java.util.Set;
public class NewsLabel {
	private Integer id;
	private String name;
	//关联属性，指定子栏目，即多方
	private Set<NewsLabel> children;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<NewsLabel> getChildren() {
		return children;
	}
	public void setChildren(Set<NewsLabel> children) {
		this.children = children;
	}
	@Override
	public String toString() {
		return "NewsLabel [id=" + id + ", name=" + name + ", children=" + children + "]";
	}
	
	
}
