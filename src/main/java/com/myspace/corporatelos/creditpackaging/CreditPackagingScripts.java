package com.myspace.corporatelos.creditpackaging;

public class CreditPackagingScripts implements java.io.Serializable {

	static final long serialVersionUID = 1L;

	public CreditPackagingScripts() {
	}

	public static void checkPaymentHistory(
			org.kie.api.runtime.process.ProcessContext kcontext) {
		try {
			System.out.println("response: "
					+ kcontext.getVariable("response").toString());
			org.json.JSONObject responseObj = new org.json.JSONObject(kcontext
					.getVariable("response").toString());
			org.json.JSONArray narrativesArray = responseObj
					.getJSONArray("narratives");
			if (narrativesArray.length() > 0) {
				for (int i = 0; i < narrativesArray.length(); i++) {
					org.json.JSONObject indNarrative = new org.json.JSONObject(
							narrativesArray.get(i).toString());
					if (indNarrative.get("categoryId").equals("10")) {
						kcontext.setVariable("result", true);
						break;
					} else {
						kcontext.setVariable("result", false);
					}
				}
			} else {
				kcontext.setVariable("result", false);
			}

		} catch (Exception e) {
			System.out.println("Exception: " + e.toString());
		}
	}

	public static void prepareProcessesList(
			org.kie.api.runtime.process.ProcessContext kcontext) {
		try {
			java.util.ArrayList procList = new java.util.ArrayList();
			boolean modifiedFlag = Boolean.parseBoolean(kcontext.getVariable(
					"isModifiedFacility").toString());
			boolean newFlag = Boolean.parseBoolean(kcontext.getVariable(
					"isNewFacility").toString());
			boolean collateralAmendmentFlag = Boolean.parseBoolean(kcontext
					.getVariable("collateralAmendment").toString());
			Integer counter = Integer.parseInt(kcontext.getVariable("colCount")
					.toString());
			counter = counter + 1;
			System.out.println("PARTIESLOOPCOUNT" + counter);
			kcontext.setVariable("colCount", Integer.toString(counter));

			if (kcontext.getVariable("isIndividualParty").toString()
					.equals("true")) {
				procList.add("CorporateLOS.ConsumerBureau");
				procList.add("CorporateLOS.ConsumerScore");
				procList.add("CorporateLOS.FinancialSpread");

				procList.add("CorporateLOS.PaymentHistory");
				procList.add("CorporateLOS.RiskRating");

			}
			if (newFlag) {
				procList.add("CorporateLOS.BusinessBureau");
				procList.add("CorporateLOS.BusinessScore");
				procList.add("CorporateLOS.FinancialSpread");

				procList.add("CorporateLOS.PaymentHistory");
				procList.add("CorporateLOS.RiskRating");

				System.out.println("SCRIPT COUNT" + counter);
				if (counter <= 1) {
					procList.add("InfinityAssist.OutstandingCollateralDetailsLoop");
					procList.add("InfinityAssist.ReviewAppraisalCollateralLoop");
					procList.add("CorporateLOS.CreateNarratives");
					if (!kcontext.getVariable("purposeId").toString()
							.equals("03")) {
						procList.add("CorporateLOS.OpportunityMemoGeneration");
					}
					procList.add("InfinityAssist.ComplianceAndPolicyExceptionRulesChecks");
					procList.add("InfinityAssist.LienSearch");
					procList.add("InfinityAssist.ExposureLoop");
				}
			}
			if (modifiedFlag) {
				procList.add("CorporateLOS.FinancialSpread");

				if (kcontext.getVariable("isIndividualParty").toString()
						.equals("true")) {
					procList.add("CorporateLOS.ConsumerBureau");
					procList.add("CorporateLOS.ConsumerScore");
				} else {
					procList.add("CorporateLOS.BusinessBureau");
					procList.add("CorporateLOS.BusinessScore");
				}
				if (counter <= 1) {
					procList.add("InfinityAssist.ComplianceAndPolicyExceptionRulesChecks");
					procList.add("InfinityAssist.LienSearch");
					procList.add("InfinityAssist.ExposureLoop");
				}

			}
			if (modifiedFlag && collateralAmendmentFlag) {
				procList.add("InfinityAssist.OutstandingCollateralDetailsLoop");
				procList.add("InfinityAssist.ReviewAppraisalCollateralLoop");
				procList.add("InfinityAssist.LienSearch");
			}
			java.util.LinkedHashSet uniqueProcessesList = new java.util.LinkedHashSet<>();
			uniqueProcessesList.addAll(procList);
			procList.clear();
			procList.addAll(uniqueProcessesList);

			kcontext.setVariable("processesList", procList);
		} catch (Exception e) {
			System.out.println("Exception: " + e.toString());
		}
	}
	public static void checkReviewAppraisal(
			org.kie.api.runtime.process.ProcessContext kcontext) {
		try {
			org.json.JSONObject responseJSON = new org.json.JSONObject(kcontext
					.getVariable("docResponse").toString());
			if (responseJSON.has("documentsList")) {
				org.json.JSONArray documentsArray = responseJSON
						.getJSONArray("documentsList");
				if (documentsArray.length() > 0) {
					for (int i = 0; i < documentsArray.length(); i++) {
						org.json.JSONObject indDocument = new org.json.JSONObject(
								documentsArray.get(i).toString());
						if (indDocument.get("documentType").equals(
								"aprsl_vlutin_insrnce")
								&& indDocument.get("category").equals(
										"collatrl_doc")) {
							kcontext.setVariable("result", true);
							break;
						} else {
							kcontext.setVariable("result", false);
						}
					}
				} else {
					kcontext.setVariable("result", false);
				}
			} else {
				kcontext.setVariable("result", false);
			}
		} catch (Exception e) {
			System.out.println("Exception: " + e.toString());
		}
	}

}