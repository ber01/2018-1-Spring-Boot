package org.zerock.persistence;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
	
	@Select("select now()")
	public String getTime();
	
	public String getTimeXML();

}
