package com.tr.obss.ELearningApp;


import com.tr.obss.ELearningApp.config.ScopeAppConfig;
import com.tr.obss.ELearningApp.entity.ELearningContent;
import com.tr.obss.ELearningApp.entity.VideoContent;
import com.tr.obss.ELearningApp.service.Impl.ELearningServiceImpl;
import com.tr.obss.ELearningApp.service.Impl.VideoServiceImpl;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Date;

@SpringBootApplication
public class ELearningAppApplication {

	static ELearningServiceImpl eLearningService;

	static VideoServiceImpl videoService;

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(ScopeAppConfig.class);
		eLearningService = context.getBean(ELearningServiceImpl.class);
		videoService = context.getBean(VideoServiceImpl.class);

		System.out.print("elearning:");eLearningService.getContentCache().printCacheSize();
		ELearningContent eLearningContent = new ELearningContent(1l,"name",new Date(),new Date(),23l,"url");
		eLearningService.createNewElearningContent(eLearningContent);
		System.out.print("elearning:");eLearningService.getContentCache().printCacheSize();

		System.out.print("video:");videoService.getContentCache().printCacheSize();
		VideoContent videoContent = new VideoContent(2l,"name",new Date(),new Date(),23l,"url");
		videoService.createNewVideoContent(videoContent);
		System.out.print("video:");videoService.getContentCache().printCacheSize();

		((ConfigurableApplicationContext)context).close();


	}

}
