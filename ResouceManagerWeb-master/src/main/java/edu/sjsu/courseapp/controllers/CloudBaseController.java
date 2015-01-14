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
import edu.sjsu.courseapp.dao.jdbc.InstanceDaoJdbcImpl;
import edu.sjsu.courseapp.dao.jdbc.RateDaoJdbcImpl;
import edu.sjsu.courseapp.dao.jdbc.UserDaoJdbcImpl;
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
			modelView = new ModelAndView("clouds");
			CloudDaoJdbcImpl cs = (CloudDaoJdbcImpl)context1.getBean("cloudServ");
			modelView.addObject("cloud_list", cs.getCloudallList());
			return modelView;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelView;
	}
	
	
	/**
	 * Load the instances page jsp 
	 * @return
	 */
	@RequestMapping(value = "/instances", method = RequestMethod.GET)
	public ModelAndView newInstanceDataForm() {
		ModelAndView modelView=null;
		try {
			modelView = new ModelAndView("instances");
			InstanceDaoJdbcImpl cs = (InstanceDaoJdbcImpl)context1.getBean("instanceServ");
			modelView.addObject("instance_list", cs.getInstanceallList());
			return modelView;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelView;
	}
	
	
	/**
	 * Load the users page jsp 
	 * @return
	 */
	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ModelAndView newUserDataForm() {
		ModelAndView modelView=null;
		try {
			modelView = new ModelAndView("users");
			UserDaoJdbcImpl cs = (UserDaoJdbcImpl)context1.getBean("userServ");
			modelView.addObject("user_list", cs.getUserallList());
			return modelView;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelView;
	}
	
	/**
	 * Load the rates page jsp 
	 * @return
	 */
	@RequestMapping(value = "/rates", method = RequestMethod.GET)
	public ModelAndView newRateDataForm() {
		ModelAndView modelView=null;
		try {
			modelView = new ModelAndView("rates");
			RateDaoJdbcImpl cs = (RateDaoJdbcImpl)context1.getBean("rateServ");
			modelView.addObject("rate_list", cs.getRateallList());
			return modelView;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelView;
	}
	
	/**
	 * Load the home page jsp 
	 * @return
	 */
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView newHomeDataForm() {
		ModelAndView modelView=null;
		try {
			modelView = new ModelAndView("home");
			return modelView;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return modelView;
	}
	
	/**
	 * function to call the request genarator 
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
