/**
 *
 */

package org.nuxeo.notification.digest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.nuxeo.ecm.automation.core.Constants;
import org.nuxeo.ecm.automation.core.annotations.Context;
import org.nuxeo.ecm.automation.core.annotations.Operation;
import org.nuxeo.ecm.automation.core.annotations.OperationMethod;
import org.nuxeo.ecm.automation.core.annotations.Param;
import org.nuxeo.ecm.core.api.CoreSession;
import org.nuxeo.ecm.core.api.DocumentModel;

/**
 * @author mikeobrebski
 */
@Operation(id=DigestNotificationSubscribe.ID, category=Constants.CAT_NOTIFICATION, label="DigestNotificationSubscribe", description="")
public class DigestNotificationSubscribe {

    private Log logger = LogFactory.getLog(DigestNotificationSubscribe.class);
    public static final String ID = "DigestNotificationSubscribe";
    public static final String DigestNotificationFacet = "digestnotificationfacet";

    @Context
    protected CoreSession session;

    @Param(name = "scope", required = false)
    protected String scope;

    @OperationMethod
    public DocumentModel run(DocumentModel doc) {
        if(doc == null){
            logger.warn("Input Document not found");
            return null;
        }

        logger.info("DigestNotificationSubscribe: "+doc.getId()+" / "+scope);


        doc.addFacet(DigestNotificationFacet);

        session.save();
        return doc;

    }

    /*
    @OperationMethod
    public DocumentModel run(DocumentModel doc) throws Exception {
        return doc;
    }

    @OperationMethod
    public DocumentModelList run(DocumentModelList docs) throws Exception {
        return docs;
    }

    @OperationMethod
    public DocumentModelList run(DocumentRefList docs) throws Exception {
        return null;
    }
    */
}
