package org.elasticsearch.flume;

import com.cloudera.flume.conf.Context;
import com.cloudera.flume.conf.SinkFactory;
import com.cloudera.flume.core.EventSink;

class ElasticSearchSinkBuilder extends SinkFactory.SinkBuilder {

    @Override
    public EventSink build(Context context, String... argv) {

        if (argv.length > 3) {
            throw new IllegalArgumentException(
                    "usage: elasticSearchSink[([clusterName, indexName, esHostNames])");
        }

        ElasticSearchSink sink = new ElasticSearchSink();
        int index = 0;
        if (argv.length>0) {
            sink.setClusterName(argv[index++]);
        }
        if (argv.length>1) {
            sink.setIndexName(argv[index++]);
        }
        if (argv.length>2) {
            sink.setHostNames(argv[index++].split(","));
        }

        return sink;

    }
}
