{"id":"8cbc461f-80ad-48a8-a99a-b625693e6605","name":"CorporateLOS.FinalDecision-taskform.frm","model":{"processName":"Final Decision","processId":"CorporateLOS.FinalDecision","name":"process","properties":[{"name":"dealId","typeInfo":{"type":"BASE","className":"java.lang.String","multiple":false},"metaData":{"entries":[]}},{"name":"decisionArray","typeInfo":{"type":"OBJECT","className":"org.json.JSONArray","multiple":false},"metaData":{"entries":[]}},{"name":"decisionList","typeInfo":{"type":"OBJECT","className":"java.lang.Object","multiple":true},"metaData":{"entries":[{"name":"field-type","value":"MultipleInput"}]}},{"name":"facilityId","typeInfo":{"type":"BASE","className":"java.lang.String","multiple":false},"metaData":{"entries":[]}},{"name":"partyId","typeInfo":{"type":"BASE","className":"java.lang.String","multiple":false},"metaData":{"entries":[]}},{"name":"payload","typeInfo":{"type":"BASE","className":"java.lang.String","multiple":false},"metaData":{"entries":[]}},{"name":"response","typeInfo":{"type":"BASE","className":"java.lang.String","multiple":false},"metaData":{"entries":[]}}],"formModelType":"org.kie.workbench.common.forms.jbpm.model.authoring.process.BusinessProcessFormModel"},"fields":[{"maxLength":100,"placeHolder":"DealId","id":"field_177523319230577E11","name":"dealId","label":"DealId","required":false,"readOnly":false,"validateOnChange":true,"binding":"dealId","standaloneClassName":"java.lang.String","code":"TextBox","serializedFieldClassName":"org.kie.workbench.common.forms.fields.shared.fieldTypes.basic.textBox.definition.TextBoxFieldDefinition"},{"maxLength":100,"placeHolder":"FacilityId","id":"field_111158442946486E12","name":"facilityId","label":"FacilityId","required":false,"readOnly":false,"validateOnChange":true,"binding":"facilityId","standaloneClassName":"java.lang.String","code":"TextBox","serializedFieldClassName":"org.kie.workbench.common.forms.fields.shared.fieldTypes.basic.textBox.definition.TextBoxFieldDefinition"},{"maxLength":100,"placeHolder":"PartyId","id":"field_3385855540382544E11","name":"partyId","label":"PartyId","required":false,"readOnly":false,"validateOnChange":true,"binding":"partyId","standaloneClassName":"java.lang.String","code":"TextBox","serializedFieldClassName":"org.kie.workbench.common.forms.fields.shared.fieldTypes.basic.textBox.definition.TextBoxFieldDefinition"}],"layoutTemplate":{"version":3,"style":"FLUID","layoutProperties":{},"rows":[{"height":"12","properties":{},"layoutColumns":[{"span":"12","height":"12","properties":{},"rows":[],"layoutComponents":[{"dragTypeName":"org.kie.workbench.common.forms.editor.client.editor.rendering.EditorFieldLayoutComponent","properties":{"field_id":"field_177523319230577E11","form_id":"8cbc461f-80ad-48a8-a99a-b625693e6605"},"parts":[]}]}]},{"height":"12","properties":{},"layoutColumns":[{"span":"12","height":"12","properties":{},"rows":[],"layoutComponents":[{"dragTypeName":"org.kie.workbench.common.forms.editor.client.editor.rendering.EditorFieldLayoutComponent","properties":{"field_id":"field_111158442946486E12","form_id":"8cbc461f-80ad-48a8-a99a-b625693e6605"},"parts":[]}]}]},{"height":"12","properties":{},"layoutColumns":[{"span":"12","height":"12","properties":{},"rows":[],"layoutComponents":[{"dragTypeName":"org.kie.workbench.common.forms.editor.client.editor.rendering.EditorFieldLayoutComponent","properties":{"field_id":"field_3385855540382544E11","form_id":"8cbc461f-80ad-48a8-a99a-b625693e6605"},"parts":[]}]}]}]}}