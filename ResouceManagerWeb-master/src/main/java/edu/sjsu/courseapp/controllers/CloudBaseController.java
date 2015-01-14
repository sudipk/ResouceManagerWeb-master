package edu.sjsu.courseapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.sjsu.courseapp.jms.SimpleMessageProducer;

import edu.sjsu.courseapp.dao.jdbc.CloudDaoJdbcImpl;
import edu.sjsu.courseapp.services.CloudService;
import edu.sjsu.courseapp.services.CloudServiceImpl;


@Controller
public class CloudBaseController {

	@Autowired
	CloudService cloudservice;
	private static ApplicationContext context ;
	private static  ApplicationContext context1 ;
	
	static{
		context= new ClassPathXmlApplicationContext("producer-jms-context.xml");
		context1= new ClassPathXmlApplicationContext("root-context.xml");
	}
	/**
	 * Load the index page jsp 
	 * @return
	 */
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public ModelAndView newProductDataForm() {
		ModelAndView modelView;
		modelView = new ModelAndView("index");
		return modelView;
	}
	
	/**
	 * Load the clouds page jsp 
	 * @return
	 */
	@RequestMapping(value = "/clouds", method = RequestMethod.GET)
	public ModelAndView newCloudDataForm() {
		ModelAndView modelView=null;
		try {
			ModelAndView modelView1;
			modelView1 = new ModelAndView("clouds");
			//CloudServiceImpl cs =  new CloudServiceImpl();
			CloudDaoJdbcImpl cs = (CloudDaoJdbcImpl)context1.getBean("cloudServ");
			modelView1.addObject("cloud_list", cs.getCloudallList());
			return modelView1;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelView;
	}
	/**
	 * function to call the requst genarator 
	 * @return
	 */
	@RequestMapping(value = "/requestGenerator", method = RequestMethod.POST)
	public ModelAndView newRequestGenerator() {
		ModelAndView modelView=null;
		try {
		      SimpleMessageProducer messageProducer = (SimpleMessageProducer) context.getBean("messageProducer");
		      messageProducer.sendMessages();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelView;
	}
}
