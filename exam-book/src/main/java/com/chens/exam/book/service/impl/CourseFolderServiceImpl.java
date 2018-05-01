package com.chens.exam.book.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.chens.exam.core.enums.ExamFileTypeEnum;
import com.chens.folder.vo.FolderFileInfo;
import com.chens.exam.core.entity.book.Course;
import com.chens.exam.core.entity.book.CourseFolder;
import com.chens.exam.book.mapper.CourseFolderMapper;
import com.chens.exam.book.service.ICourseFolderService;
import com.chens.exam.book.service.ICourseService;
import com.chens.folder.vo.service.impl.AbstractFolderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 *  资源服务实现类
 *
 * @author chunlei.song@live.com
 * @create 2018-04-01
 */
@Service
public class CourseFolderServiceImpl extends AbstractFolderServiceImpl<CourseFolderMapper, CourseFolder> implements ICourseFolderService {

    @Autowired
    private ICourseService courseService;

    @Override
    protected String initType() {
        return ExamFileTypeEnum.COURSE.getCode();
    }

    @Override
    protected List<FolderFileInfo> getFileInfoListByFolderId(String folderId) {
        List<FolderFileInfo> folderFileInfoList = new ArrayList<>();
        Course course = new Course();
        course.setFolderId(folderId);
        EntityWrapper<Course> courseEntityWrapper = new EntityWrapper<>(course);
        List<Course> courseList = courseService.selectList(courseEntityWrapper);
        for (Course file:courseList)
        {
            folderFileInfoList.add(file.getFolderInfo());
        }
        return folderFileInfoList;
    }
}
