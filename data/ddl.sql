CREATE TABLE `career_summary` (
  `id` bigint(20) NOT NULL,
  `career_summary_description` varchar(4000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

ALTER TABLE `resume`.`career_summary` 
CHANGE COLUMN `id` `id` BIGINT(20) NOT NULL AUTO_INCREMENT ;

CREATE TABLE `professional_experience` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `employer_name` varchar(255) DEFAULT NULL,
  `exp_details` varchar(10000) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


ALTER TABLE `resume`.`professional_experience` 
CHANGE COLUMN `id` `id` BIGINT(20) NOT NULL AUTO_INCREMENT ;

ALTER TABLE `resume`.`professional_experience` 
ADD COLUMN `exp_details` VARCHAR(10000) NULL AFTER `employer_name`;

update professional_experience set exp_details = 'This is a Fortune 500 Health Care Pharmacy Ecommerce Company. The role deals with multiple monolithic application migration to a Microservice based Cloud Architecture'
where id = 7;

update professional_experience set exp_details = 'Solstice is a Consulting Company. The role was responsible for AWS Cloud Architecture, Spring Cloud Netflix Microservices Architecture as well as grooming the new Cloud Native Team at Solstice"'
where id = 8;

update professional_experience set exp_details = 'West Monroe is a Consulting Company. The role was responsible for AWS Cloud Architecture, Cloud based Continuous Integration & Deployment (CI/CD), Spring Cloud Netflix Microservices Architecture as well as grooming the new Cloud Native Team at Solstice"'
where id = 9;


update professional_experience set exp_details = 'Sears Holdings Corporation has multiple high transactional volume Ecommerce websites such as sears.com, kmart.com, kenmore.com, craftsman.com as well as others. All the websites share a complex distributed architecture using state of art technologies involving relational as well as NoSQL data storage platforms, load balanced JVMs running Java Web applications with Apache Web Server , MOD_JK and Apache Tomcat. The Product Detail Page (PDP) is an important page of the websites where customers actually view , learn, compare , decide and finally buy the product. The single page application (SPA) is built using HTML5, Backbone.js, Chaplin, Handlebar, Bootstrap, CoffeeScript and makes a series of AJAX calls to the backend PDP Service REST layer. The PDP Services REST application aggregates and accumulates information from other internal services such as Dynamic Page Template service, Product Content Service, Fulfillment Services(Delivery, Shipping, Store Pick UP), Ecoupon Services, Promotion Service, Rebates Service, Add To Cart Service, among others. The Dynamic Page Template service is unique as it enables Sears to use the same front end SPA application JavaScript / CoffeeScript code to load pages that look very different to the users of the different web sites. During non peak time, the cluster receives 50,000 calls per second on an average, while during the Thanksgiving weekend, the peak load routinely goes above 75,000 calls per second. Due to Sears robust load testing effort all throughout the year, on several occasions in a typical month, there is SOASTA testing that tests the website in level 1 through level 4 as well. Besides, this application, the PDP Services team also develops and maintains two other REST APIs such as the Auto Fitment services application (used by Auto Parts products) as well as Browse Services which are used by the Product Listing Page (PLP).'
where id = 10;

update professional_experience set exp_details = 'Northern Trust purchased the Pivotal Cloud Foundry PaaS platform to migrate their old Java legacy application to a private PaaS environment. This project is about installing the Pivotal Cloud Foundry product on top of VMware vSphere and porting three of the legacy Java EJB application to run on Cloud Foundry.'
where id = 11;

update professional_experience set exp_details = ' User Metadata Management 3.0 (UDM 3.0) UDM : User Metadata Management is application integration project that presents a Browser based UI to view, edit, insert , delete and upload metadata for a 56 different application areas like AppleCare, Apple Online Store and so on. Its UI is built using ExtJS, the service layer using Spring framework, Spring JDBC and Spring AOP. It also integrates with several of Apples internal system for file storage, data transfer from the stage table to the core application table, sending mails etc. It uses RabitMQ for sending messages to the eventing framework which transfer data from stage table to the core table. It uses Oracle as its own configuration database and the primary application database is in Teradata. When a new application is commission in UDM, the application owner fills up a form which is then entered into the Oracle config database. From that point on, the application users are enabled to use the UDM interface to their data related tasks..'
where id = 12;

update professional_experience set exp_details = 'The Probe Data application is a Core java based application that processes GPS data received from cell phone service providers to analyze missing road geometries to eventually help enhance Nokia road network products. It has a Hadoop cluster and associated Map Reduce programs to apply algorithms on GPS Data to learn about driving patterns on new roads. It also has, a series of core java components to create potential road images i.e. clusters based on GPS points. Apart from these two main components, it also has a single web application for report generation, and a desktop application (C#) for viewing missing roads and a crowdsourcing framework for reviewing road networks maps. These components relies on Hadoop, JMS using QPid, core java, spring framework, hibernate and JDBC, and PLSQL.'
where id = 13;

update professional_experience set exp_details = ' This is an internal website that helps Pearson users centrally view / manage capacity / availability for their entire test centers located all over the world in different regions and countries. This replaces a test center specific availability management desktop tool which is cumbersome and very time consuming. The GUI is delivered through Apache MyFaces and the service back end is implemented using apache CXF, JAX-WS and JAXB. The database is MS SQL Server..'
where id = 14;

update professional_experience set exp_details = ' This is a website that helps Jostens clients [schools / colleges / organization, universities etc] create, design, edit, and upload images, print copies of Yearbooks. The websites page designer tool is template based and helps the user(s) get started in no time. The page designer has tools to add images, different shapes, text in various forms lines; the website helps the users keep history data as well. The front end of this application is built in Adobe Flex 3.x and the web services are implemented in J2EE, Spring Framework, Hibernate, Groovy, Grails. The Flex application communicates in XML with the j2ee backend. The marshalling and un-marshalling is taken care of by the JibX bind tool. '
where id = 15;

update professional_experience set exp_details = ' It is a web based premium provider information search engine used by United Health Group internal nurses for health care providers, Physicians and Facilities / Hospital information retrieval, analysis and value added comparison. The current effort is on to publish this product for general public to be used over the Internet.. '
where id = 16;

update professional_experience set exp_details = ' It is a web based enterprise application that serves as an MIS application for rebates analysis and approval of allocated payments done by the Client Share Batch application. It supports setting up / querying Client Hierarchies like Super Client, Client Divisions, Plan Types, BPL and Groups and manage their relationships. It also supports creation / modification of rules for allocation and assigning the rules to various client hierarchy levels, Financial Close activities, and creation of Allocation Periods, Processed periods and review and approval of payments through various payment statuses. Additionally it has multiple groups of online drill down reports for various levels of management. '
where id = 17;

update professional_experience set exp_details = ' CORE (Common Opportunities, Results, and Experiences): Implementation / Customization of Enterprise Originations (EO) product from CGI-AMS. CORE is the umbrella project that is broken down into three functional tiers with associated delivery teams: Customer Facing, Deal Processing, and Deal Decisioning. The primary business driver of CORE is to allow the business to meet speed to market needs; this pervades into almost every aspect of the loan origination process using Service Oriented Architectures (SOA) and Web Services. '
where id = 18;

update professional_experience set exp_details = ' Core Services forms the business logic layer of Dial and DSL customers of BellSouths Broadband business. Core Services session beans were exposed as Web services deployed in Weblogic App Server to server as the backbone of the SOA architecture. Core Services is the functional back end for a assortment of client application that are responsible from Dial Ordering (REAP), different types DSL ordering (Oracle CRM), Customer Care Tool (CCTOOL), Billing Change Tool (BCTOOL), XML Gateway, CRG to name a few. '
where id = 19;

update professional_experience set exp_details = ' This project is to develop and implement a Web-Based Integrated Transactional Enterprise Application system, named CoalNet Application, for Coal India Limited (CIL) and all of its Subsidiary Companies covering all of their business areas and served as a Service Oriented backbone of en entire company using session beans exposed as Web Services'
where id = 20;

update professional_experience set exp_details = 'This was an ERP Application Development project including all regular modules such as Finance, Materials, Purchase, Sales & Distribution, Payroll, Personnel and others for a Plastic Bag Manufacturong Client.'
where id = 21;

update professional_experience set exp_details = 'This was an ERP Application Development project including all regular modules such as Finance, Materials, Purchase, Sales & Distribution, Payroll, Personnel and others for the Royal Calcutta Turf Clubs (RCTC) as Client'
where id = 22;

CREATE TABLE `professional_experience_tech_contribution` (
  `id` bigint(20) NOT NULL,
  `tech_controbution_made` varchar(255) DEFAULT NULL,
  `prof_exp_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKbelh6l9kl5753pj9w77s40ys3` (`prof_exp_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



ALTER TABLE `resume`.`professional_experience_technology_used` 
CHANGE COLUMN `id` `id` BIGINT(20) NOT NULL AUTO_INCREMENT ;

CREATE TABLE `professional_experience_technology_used` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `technology_used` varchar(255) DEFAULT NULL,
  `prof_exp_id` bigint(20) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKa9qadcy7pd6mqspa8yd803ob7` (`prof_exp_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `education` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `college_name` varchar(255) DEFAULT NULL,
  `degree_name` varchar(255) DEFAULT NULL,
  `gpa` double DEFAULT NULL,
  `is_vendor_certification` bit(1) DEFAULT NULL,
  `university_name` varchar(255) DEFAULT NULL,
  `year_completed` int(11) DEFAULT NULL,
  `year_started` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


ALTER TABLE `resume`.`education` 
CHANGE COLUMN `id` `id` BIGINT(20) NOT NULL AUTO_INCREMENT ;

CREATE TABLE `skill` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `business_domain_specific_skill_details` varchar(255) DEFAULT NULL,
  `is_business_domain_skill` bit(1) DEFAULT NULL,
  `num_years` int(11) DEFAULT NULL,
  `skill_details` varchar(255) DEFAULT NULL,
  `skill_name` varchar(255) DEFAULT NULL,
  `year_gained` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


ALTER TABLE `resume`.`skill` 
CHANGE COLUMN `id` `id` BIGINT(20) NOT NULL AUTO_INCREMENT ;

ALTER TABLE `resume`.`skill` 
CHANGE COLUMN `business_domain_specific_skill_details` `business_domain_specific_skill_details` VARCHAR(1000) NULL DEFAULT NULL ,
CHANGE COLUMN `skill_details` `skill_details` VARCHAR(4000) NULL DEFAULT NULL ,
CHANGE COLUMN `skill_name` `skill_name` VARCHAR(4000) NULL DEFAULT NULL ;

