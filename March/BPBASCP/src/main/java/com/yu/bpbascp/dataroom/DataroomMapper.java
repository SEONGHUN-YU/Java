package com.yu.bpbascp.dataroom;

import java.util.List;

public interface DataroomMapper {
	public abstract int upload(DataroomFile df);
	public abstract List<DataroomFile> getFile();
}
