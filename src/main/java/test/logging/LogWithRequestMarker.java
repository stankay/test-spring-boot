package test.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class LogWithRequestMarker {
    private static final Logger LOG = LoggerFactory.getLogger(LogWithRequestMarker.class);

    public static final Marker REQUEST_MARKER = MarkerFactory.getMarker("REQUEST");
    public static final Marker SCHEDULER_MARKER = MarkerFactory.getMarker("SCHEDULER");
    public static final Marker DMO_DELIVERY_WS_SERVICE_MARKER  = MarkerFactory.getMarker("DMO_DELIVERY_WS_SERVICE_MARKER");
    public static final Marker DA_DOCUMENT_WS_SERVICE_MARKER   = MarkerFactory.getMarker("DA_DOCUMENT_WS_SERVICE_MARKER");
    public static final Marker MOVE_DOC_WS_SERVICE_MARKER      = MarkerFactory.getMarker("MOVE_DOC_WS_SERVICE_MARKER");
    public static final Marker DA_IMPORT_WS_SERVICE_MARKER     = MarkerFactory.getMarker("DA_IMPORT_WS_SERVICE_MARKER");
    public static final Marker TIA_GET_CLAIM_EVENT_MARKER      = MarkerFactory.getMarker("TIA_GET_CLAIM_EVENT_MARKER");
    public static final Marker TIA_SUBCLAIMS_CLAIM_ITEM_MARKER = MarkerFactory.getMarker("TIA_SUBCLAIMS_CLAIM_ITEM_MARKER");
    public static final Marker TIA_CREATE_ITEM_CASE_MARKER     = MarkerFactory.getMarker("TIA_CREATE_ITEM_CASE_MARKER");

    @Scheduled(cron = "*/5 * * * * ?")
    public void generate() {
        LOG.info(REQUEST_MARKER, "hello with " + REQUEST_MARKER);
        LOG.info(SCHEDULER_MARKER, "hello with " + SCHEDULER_MARKER);
        LOG.info(DMO_DELIVERY_WS_SERVICE_MARKER, "hello with " + DMO_DELIVERY_WS_SERVICE_MARKER);
        LOG.info(DA_DOCUMENT_WS_SERVICE_MARKER, "hello with " + DA_DOCUMENT_WS_SERVICE_MARKER);
        LOG.info(MOVE_DOC_WS_SERVICE_MARKER, "hello with " + MOVE_DOC_WS_SERVICE_MARKER);
        LOG.info(DA_IMPORT_WS_SERVICE_MARKER, "hello with " + DA_IMPORT_WS_SERVICE_MARKER);
        LOG.info(TIA_GET_CLAIM_EVENT_MARKER, "hello with " + TIA_GET_CLAIM_EVENT_MARKER);
        LOG.info(TIA_SUBCLAIMS_CLAIM_ITEM_MARKER, "hello with " + TIA_SUBCLAIMS_CLAIM_ITEM_MARKER);
        LOG.info(TIA_CREATE_ITEM_CASE_MARKER, "hello with " + TIA_CREATE_ITEM_CASE_MARKER);
    }
}
