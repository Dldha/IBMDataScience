package com.bank.user.services;

import com.misys.equation.common.access.EquationStandardSession;
import com.misys.equation.common.access.EquationStandardTransaction;
import com.misys.equation.common.files.JournalHeader;
import com.misys.equation.common.internal.eapi.core.EQException;
import com.misys.equation.common.utilities.EquationLogger;
import com.misys.equation.function.adaptor.AbstractFunctionAdaptor;
import com.misys.equation.function.runtime.UserData;
import com.misys.equation.function.runtime.UserModifyData;
import com.misys.equation.function.tools.FunctionRuntimeToolbox;
import com.misys.equation.function.adaptor.AbstractInputFieldSetAdaptor;

/** 
 * Implementation for WY1
 */
public class WY1 extends AbstractFunctionAdaptor {
	/** 
	 * Plug-in version
	 */
	public static final String PLUGIN_VERSION = "004.000.004";
	/** 
	 * Release version
	 */
	public static final String RELEASE_VERSION = "";
	/**
	 * Allows bank to perform database retrieval.
	 */
	private static final EquationLogger LOG = new EquationLogger(WY1.class);
	@Override
	public String postLoad(UserModifyData userModifyData) {
		try
		{
			
			EquationStandardTransaction transaction = getTransaction(userModifyData);
			transaction.setFieldValue("GZDLP", userModifyData.rtvFieldInputValue("WY1_DLP"));
			transaction.setFieldValue("GZDLR", userModifyData.rtvFieldInputValue("WY1_DLR"));			
			transaction.setFieldValue("GZBRNM", userModifyData.rtvFieldDbValue("WY1_BRNM"));
			transaction.setFieldValue("GZEXT", "N");
			userModifyData.getUserAccessHandler().getEquationUser().getSession().retrieveEquationTransaction(transaction);

			loadData(transaction, userModifyData);

			if (!transaction.getValid())
			{
				getReturnMessages().addMessage(transaction.getErrorList().get(0).getDsepms());
			}
			
		}
		catch (Exception e)
		{
			e.printStackTrace();
			getReturnMessages().addError("Post load call fails");
		}

	
		return "A";
	}
	/**
	 * Return an Equation Standard Transaction for the RDW transaction
	 * 
	 * @param userData
	 *            - the user data
	 * @return an Equation Standard Transaction for the CP transaction
	 * 
	 * @throws EQException
	 */
	private EquationStandardTransaction getTransaction(UserData userData) throws EQException
	{
		return new EquationStandardTransaction("J42ARRRDW", userData
						.getUserAccessHandler().getEquationUser().getSession());

	}

	/**
	 * Load details from CP
	 * 
	 * @param transaction
	 *            - the transaction
	 * @param userData
	 *            - the user data
	 */
	private void loadData(EquationStandardTransaction transaction, UserModifyData userData)
	{
		userData.chgFieldDbValue("", transaction.getFieldValue(""));
		userData.chgFieldDbValue("WY1_CUS", transaction.getFieldValue("GZCUS"));
		userData.chgFieldDbValue("WY1_CLC", transaction.getFieldValue("GZCLC"));
		
		userData.chgFieldDbValue("WY1_GRP", transaction.getFieldValue("GZGRP"));
		
		userData.chgFieldDbValue("WY1_TDT", transaction.getFieldValue("GZTDT"));
		userData.chgFieldDbValue("ZLPCCY", transaction.getFieldValue("GZPCCY"));
		userData.chgFieldDbValue("ZLCCY1", transaction.getFieldValue("GZCCY1"));
		userData.chgFieldDbValue("ZLCCY2", transaction.getFieldValue("GZCCY2"));
		userData.chgFieldDbValue("ZLDLA", transaction.getFieldValue("GZDLA"));
		userData.chgFieldDbValue("WY1_IA", transaction.getFieldValue("GZIA"));
		userData.chgFieldDbValue("WY1_TIA", transaction.getFieldValue("GZTIA"));
		userData.chgFieldDbValue("WY1_MDT", transaction.getFieldValue("GZMDT"));
		userData.chgFieldDbValue("WY1_SDTE", transaction.getFieldValue("GZSDTE"));
		userData.chgFieldDbValue("WY1_WDT", transaction.getFieldValue("GZWDT"));
		userData.chgFieldDbValue("WY1_LRE", transaction.getFieldValue("GZLRE"));
		//userData.chgFieldDbValue("WY1_INC", transaction.getFieldValue("GZINC"));
		userData.chgFieldDbValue("WY1_NRD", transaction.getFieldValue("GZNRD"));
		userData.chgFieldDbValue("WY1_NCD", transaction.getFieldValue("GZNCD"));
		userData.chgFieldDbValue("WY1_CBRR", transaction.getFieldValue("GZCBRR"));
		userData.chgFieldDbValue("WY1_CDRR", transaction.getFieldValue("GZCDRR"));
		userData.chgFieldDbValue("WY1_CRTM", transaction.getFieldValue("GZCRTM"));
		userData.chgFieldDbValue("WY1_CIRT", transaction.getFieldValue("GZCIRT"));
		userData.chgFieldDbValue("WY1_CPEG", transaction.getFieldValue("GZCPEG"));
		userData.chgFieldDbValue("ZLEBRR", transaction.getFieldValue("GZEBRR"));
		userData.chgFieldDbValue("ZLEDRR", transaction.getFieldValue("GZEDRR"));
		userData.chgFieldDbValue("ZLERTM", transaction.getFieldValue("GZERTM"));
		userData.chgFieldDbValue("ZLEART", transaction.getFieldValue("GZEART"));
		userData.chgFieldDbValue("ZLEPEG", transaction.getFieldValue("GZEPEG"));
		userData.chgFieldDbValue("WY1_CCD1", transaction.getFieldValue("GZCCD1"));
		userData.chgFieldDbValue("WY1_PAM1", transaction.getFieldValue("GZPAM1"));
		userData.chgFieldDbValue("WY1_CCD2", transaction.getFieldValue("GZCCD2"));
		userData.chgFieldDbValue("WY1_PAM2", transaction.getFieldValue("GZPAM2"));
		userData.chgFieldDbValue("WY1_CCD3", transaction.getFieldValue("GZCCD3"));
		userData.chgFieldDbValue("WY1_PAM3", transaction.getFieldValue("GZPAM3"));
		userData.chgFieldDbValue("WY1_WA", transaction.getFieldValue("GZWA"));
		userData.chgFieldDbValue("WY1_XMM", transaction.getFieldValue("GZXMM"));
		userData.chgFieldDbValue("WY1_DPAM", transaction.getFieldValue("GZDPAM"));
		userData.chgFieldDbValue("WY1_DIAM", transaction.getFieldValue("GZDIAM"));
		userData.chgFieldDbValue("WY1_WPAM", transaction.getFieldValue("GZWPAM"));
		userData.chgFieldDbValue("WY1_WIAM", transaction.getFieldValue("GZWIAM"));
		userData.chgFieldDbValue("ZLCWF1", transaction.getFieldValue("GZCWF1"));
		userData.chgFieldDbValue("ZLCWF2", transaction.getFieldValue("GZCWF2"));
		userData.chgFieldDbValue("ZLAB", transaction.getFieldValue("GZAB"));
		userData.chgFieldDbValue("ZLAN", transaction.getFieldValue("GZAN"));
		userData.chgFieldDbValue("ZLAS", transaction.getFieldValue("GZAS"));
		userData.chgFieldDbValue("WY1_EAN", transaction.getFieldValue("GZEAN"));
		userData.chgFieldDbValue("ZLAB1", transaction.getFieldValue("GZAB1"));
		userData.chgFieldDbValue("ZLAN1", transaction.getFieldValue("GZAN1"));
		userData.chgFieldDbValue("ZLAS1", transaction.getFieldValue("GZAS1"));
		userData.chgFieldDbValue("WY1_EAN1", transaction.getFieldValue("GZEAN1"));
		userData.chgFieldDbValue("WY1_OAB", transaction.getFieldValue("GZOAB"));
		userData.chgFieldDbValue("WY1_OAN", transaction.getFieldValue("GZOAN"));
		userData.chgFieldDbValue("WY1_OAS", transaction.getFieldValue("GZOAS"));
		userData.chgFieldDbValue("WY1_OAB1", transaction.getFieldValue("GZOAB1"));
		userData.chgFieldDbValue("WY1_OAN1", transaction.getFieldValue("GZOAN1"));
		userData.chgFieldDbValue("WY1_OAS1", transaction.getFieldValue("GZOAS1"));		
		userData.chgFieldDbValue("ZLPRTC", transaction.getFieldValue("GZPRTC"));
		userData.chgFieldDbValue("WY1_CANR", transaction.getFieldValue("GZCANR"));
		userData.chgFieldDbValue("WY1_YPSF", transaction.getFieldValue("GZYPSF"));
		userData.chgFieldDbValue("ZLPSIF", transaction.getFieldValue("GZPSIF"));
		userData.chgFieldDbValue("WY1_CPI", transaction.getFieldValue("GZCPI"));
		userData.chgFieldDbValue("WY1_OCY1", transaction.getFieldValue("GZOCY1"));
		userData.chgFieldDbValue("WY1_OCY2", transaction.getFieldValue("GZOCY2"));
		userData.chgFieldDbValue("WY1_DIC", transaction.getFieldValue("GZDIC"));
		userData.chgFieldDbValue("WY1_LCD", transaction.getFieldValue("GZLCD"));
		userData.chgFieldDbValue("WY1_TOS", transaction.getFieldValue("GZTOS"));
		userData.chgFieldDbValue("WY1_IAD", transaction.getFieldValue("GZIAD"));
		userData.chgFieldDbValue("WY1_INR", transaction.getFieldValue("GZINR"));
		userData.chgFieldDbValue("WY1_EDRT", transaction.getFieldValue("GZEDRT"));
		userData.chgFieldDbValue("WY1_MODE", transaction.getFieldValue("GZMODE"));
		userData.chgFieldDbValue("WY1_PAD", transaction.getFieldValue("GZPAD"));
		userData.chgFieldDbValue("WY1_DFR", transaction.getFieldValue("GZDFR"));
		userData.chgFieldDbValue("WY1_EXFM", transaction.getFieldValue("GZEXFM"));
		userData.chgFieldDbValue("WY1_RRTM", transaction.getFieldValue("GZRRTM"));
		userData.chgFieldDbValue("WY1_RATM", transaction.getFieldValue("GZRATM"));
		userData.chgFieldDbValue("WY1_EXFI", transaction.getFieldValue("GZEXFI"));
		userData.chgFieldDbValue("WY1_AB2", transaction.getFieldValue("GZAB2"));
		userData.chgFieldDbValue("WY1_AN2", transaction.getFieldValue("GZAN2"));
		userData.chgFieldDbValue("WY1_AS2", transaction.getFieldValue("GZAS2"));
		userData.chgFieldDbValue("WY1_EAN2", transaction.getFieldValue("GZEAN2"));
		userData.chgFieldDbValue("WY1_OAB2", transaction.getFieldValue("GZOAB2"));
		userData.chgFieldDbValue("WY1_OAN2", transaction.getFieldValue("GZOAN2"));
		userData.chgFieldDbValue("WY1_OAS2", transaction.getFieldValue("GZOAS2"));
		userData.chgFieldDbValue("WY1_BBR", transaction.getFieldValue("GZBBR"));
		userData.chgFieldDbValue("WY1_EXT", transaction.getFieldValue("GZEXT"));
		userData.chgFieldInputValue("WY1_RATI", transaction.getFieldValue("GZRATI"));
		
	
		LOG.info("Teste WY1_AB2:" +  userData.rtvFieldDbValue("WY1_AB2"));	
		LOG.info("Teste WY1_AB2:" +  userData.rtvFieldInputValue("WY1_RATI"));
		}
		
	private EquationStandardTransaction AddRDW(JournalHeader journalHeader, UserData userData) throws EQException
	{
		// get session
		EquationStandardSession session = userData.getUserAccessHandler().getEquationUser().getSession();

		// Get a new transaction for Clean Payment
		EquationStandardTransaction transaction = getTransaction(userData);
		setupRDWTransaction(transaction, userData);

		// Other details
		FunctionRuntimeToolbox.setupTransaction(transaction, journalHeader, false, false);

		// Do the invocation
		transaction.setMode("A");
		
		session.applyEquationTransaction(transaction);
		if (!transaction.getValid())
		{
			return transaction;
		}

		
		return transaction;
	}
	/**
	 * Setup RD transaction
	 * 
	 * @param transaction
	 *            - the transaction
	 * @param userData
	 *            - the user data
	 */
	private void setupRDWTransaction(EquationStandardTransaction transaction, UserData userData)
	{
		transaction.setFieldValue("GZBRNM", userData.rtvFieldDbValue("WY1_BRNM"));  //Branch mnemonic                                    
		transaction.setFieldValue("GZDLP", userData.rtvFieldDbValue("WY1_DLP"));     //Deal type                                          
		transaction.setFieldValue("GZDLR", userData.rtvFieldDbValue("WY1_DLR"));     //Deal reference 
		transaction.setFieldValue("GZCUS", userData.rtvFieldDbValue("ZLCUS"));     //Customer mnemonic                                  
		transaction.setFieldValue("GZCLC", userData.rtvFieldDbValue("WY1_CLC"));
		transaction.setFieldValue("GZEXT", userData.rtvFieldDbValue("WY1_EXT"));	//Customer location                                  
		transaction.setFieldValue("GZYPSF", userData.rtvFieldDbValue("WY1_YPSF"));	//Exclude from positions?                            
		transaction.setFieldValue("GZGRP", userData.rtvFieldDbValue("WY1_GRP")); 	//Group name                                         
		transaction.setFieldValue("GZDIC", userData.rtvFieldDbValue("WY1_DIC"));   //Deal interest characteristic; V=Var, F=Fix, D=Dis
		transaction.setFieldValue("GZTDT", userData.rtvFieldDbValue("WY1_TDT")); 	//Term deal type; L=Loan, D=Deposit                  
		transaction.setFieldValue("GZPCCY", userData.rtvFieldDbValue("ZLPCCY"));	//Deal currency
		transaction.setFieldValue("GZCCY1", userData.rtvFieldDbValue("ZLCCY1")); 	//Principal withdrawal currency 
		transaction.setFieldValue("GZCCY2", userData.rtvFieldDbValue("ZLCCY2")); 	//Interest withdrawal currency 
		transaction.setFieldValue("GZDLA", userData.rtvFieldDbValue("ZLDLA"));	//Principal amount
		transaction.setFieldValue("GZIA", userData.rtvFieldDbValue("WY1_IA"));     //Interest amount                                                                  
		transaction.setFieldValue("GZTIA", userData.rtvFieldDbValue("WY1_TIA"));	//Tax on interest 
		transaction.setFieldValue("GZSDTE", userData.rtvFieldDbValue("WY1_SDTE"));	//Start date   
		transaction.setFieldValue("GZMDT", userData.rtvFieldDbValue("WY1_MDT"));	//Maturity date
		transaction.setFieldValue("GZWDT", userData.rtvFieldDbValue("WY1_WDT"));	//Withdrawal date
		transaction.setFieldValue("GZLRE", userData.rtvFieldDbValue("WY1_LRE"));	//Last rollover date                                 
		transaction.setFieldValue("GZNRD", userData.rtvFieldDbValue("WY1_NRD"));	//Next rollover date
		transaction.setFieldValue("GZNCD", userData.rtvFieldDbValue("WY1_NCD"));	//Next cycle date                                    
		transaction.setFieldValue("GZCBRR",userData.rtvFieldDbValue("WY1_CBRR"));
		transaction.setFieldValue("GZCDRR",userData.rtvFieldDbValue("WY1_CDRR"));
		transaction.setFieldValue("GZCRTM",userData.rtvFieldDbValue("WY1_CRTM"));
		transaction.setFieldValue("GZCIRT",userData.rtvFieldDbValue("WY1_CIRT"));
		transaction.setFieldValue("GZCPEG",userData.rtvFieldDbValue("WY1_CPEG"));
		transaction.setFieldValue("GZEBRR",userData.rtvFieldDbValue("ZLEBRR"));
		transaction.setFieldValue("GZEDRR",userData.rtvFieldDbValue("ZLEDRR"));
		transaction.setFieldValue("GZERTM",userData.rtvFieldDbValue("ZLERTM"));
		transaction.setFieldValue("GZEART",userData.rtvFieldDbValue("ZLEART"));
		transaction.setFieldValue("GZEPEG",userData.rtvFieldDbValue("ZLEPEG"));
		transaction.setFieldValue("GZCCD1",userData.rtvFieldDbValue("WY1_CCD1"));
		transaction.setFieldValue("GZPAM1",userData.rtvFieldDbValue("WY1_PAM1"));
		transaction.setFieldValue("GZCCD2",userData.rtvFieldDbValue("WY1_CCD2"));
		transaction.setFieldValue("GZPAM2",userData.rtvFieldDbValue("WY1_PAM2"));
		transaction.setFieldValue("GZCCD3",userData.rtvFieldDbValue("WY1_CCD3"));
		transaction.setFieldValue("GZPAM3",userData.rtvFieldDbValue("WY1_PAM3"));
		transaction.setFieldValue("GZWA",userData.rtvFieldDbValue("WY1_WA"));
		transaction.setFieldValue("GZXMM",userData.rtvFieldDbValue("WY1_XMM"));
		transaction.setFieldValue("GZDPAM",userData.rtvFieldDbValue("WY1_DPAM"));
		transaction.setFieldValue("GZDIAM",userData.rtvFieldDbValue("WY1_DIAM"));
		transaction.setFieldValue("GZWPAM",userData.rtvFieldDbValue("WY1_WPAM"));
		 transaction.setFieldValue("GZWIAM",userData.rtvFieldDbValue("WY1_WIAM"));
		 transaction.setFieldValue("GZCWF1",userData.rtvFieldDbValue("ZLCWF1"));
		 transaction.setFieldValue("GZCWF2",userData.rtvFieldDbValue("ZLCWF2"));
		 transaction.setFieldValue("GZAB",userData.rtvFieldDbValue("ZLAB"));
		 transaction.setFieldValue("GZAN",userData.rtvFieldDbValue("ZLAN"));
		 transaction.setFieldValue("GZAS",userData.rtvFieldDbValue("ZLAS"));
		 transaction.setFieldValue("GZEAN",userData.rtvFieldDbValue("WY1_EAN"));
		 transaction.setFieldValue("GZAB1",userData.rtvFieldDbValue("ZLAB1"));
		 transaction.setFieldValue("GZAN1",userData.rtvFieldDbValue("ZLAN1"));
		 transaction.setFieldValue("GZAS1",userData.rtvFieldDbValue("ZLAS1"));
		 transaction.setFieldValue("GZEAN1",userData.rtvFieldDbValue("WY1_EAN1"));
		 transaction.setFieldValue("GZOAB",userData.rtvFieldDbValue("WY1_OAB"));
		 transaction.setFieldValue("GZOAN",userData.rtvFieldDbValue("WY1_OAN"));
		 transaction.setFieldValue("GZOAS",userData.rtvFieldDbValue("WY1_OAS"));
		 transaction.setFieldValue("GZOAB1",userData.rtvFieldDbValue("WY1_OAB1"));
		 transaction.setFieldValue("GZOAN1",userData.rtvFieldDbValue("WY1_OAN1"));
		 transaction.setFieldValue("GZOAS1",userData.rtvFieldDbValue("WY1_OAS1"));		
		 transaction.setFieldValue("GZPRTC",userData.rtvFieldDbValue("ZLPRTC"));
		 transaction.setFieldValue("GZCANR",userData.rtvFieldDbValue("WY1_CANR"));
		 transaction.setFieldValue("GZYPSF",userData.rtvFieldDbValue("WY1_YPSF"));
		 transaction.setFieldValue("GZPSIF",userData.rtvFieldDbValue("ZLPSIF"));
		 transaction.setFieldValue("GZOCY1",userData.rtvFieldDbValue("WY1_OCY1"));
		 transaction.setFieldValue("GZOCY2",userData.rtvFieldDbValue("WY1_OCY2"));
		 transaction.setFieldValue("GZDIC",userData.rtvFieldDbValue("WY1_DIC"));
		 transaction.setFieldValue("GZLCD",userData.rtvFieldDbValue("WY1_LCD"));
		 transaction.setFieldValue("GZTOS",userData.rtvFieldDbValue("WY1_TOS"));
		 transaction.setFieldValue("GZIAD",userData.rtvFieldDbValue("WY1_IAD"));
		 transaction.setFieldValue("GZINR",userData.rtvFieldDbValue("WY1_INR"));
		 transaction.setFieldValue("GZEDRT",userData.rtvFieldDbValue("WY1_EDRT"));
		 transaction.setFieldValue("GZMODE",userData.rtvFieldDbValue("WY1_MODE"));
		 transaction.setFieldValue("GZPAD",userData.rtvFieldDbValue("WY1_PAD"));
		 transaction.setFieldValue("GZDFR",userData.rtvFieldDbValue("WY1_DFR"));
		 transaction.setFieldValue("GZEXFM",userData.rtvFieldDbValue("WY1_EXFM"));
		 transaction.setFieldValue("GZRRTM",userData.rtvFieldDbValue("WY1_RRTM"));
		 transaction.setFieldValue("GZRATM",userData.rtvFieldDbValue("WY1_RATM"));
		 transaction.setFieldValue("GZEXFI",userData.rtvFieldDbValue("WY1_EXFI"));
		
		 transaction.setFieldValue("GZRRTI",userData.rtvFieldDbValue("WY1_RRTI"));
		 transaction.setFieldValue("GZRATI",userData.rtvFieldDbValue("WY1_RATI"));	
		 transaction.setFieldValue("GZF0MR","N");
		 transaction.setFieldValue("GZF0R","Y");	
		LOG.info("Teste2 WY1_AB2:" +  userData.rtvFieldDbValue("WY1_AB2"));	
		LOG.info("Teste2 WY1_AB2:" +  userData.rtvFieldInputValue("WY1_RATI"));
		               
		
	}
	/**
	 * Allows bank to perform update processing after the standard Equation update.
	 */
	 
	@Override
	public void postUpdate(JournalHeader journalHeader, UserData userData) {
	try
		{
			EquationStandardTransaction transaction = AddRDW(journalHeader, userData);
			if (!transaction.getValid())
			{
				getReturnMessages().addMessage(transaction.getErrorList().get(0).getDsepms());
				return;
			} else {
			
				 
				      
				 
					System.out.println("finished!************************************************************************");
					
					}
				
		}
		catch (Exception e)
		{
			getReturnMessages().addError("Post update call fails");
		}
		finally
		{
		}	
	}
	
	
	
}
