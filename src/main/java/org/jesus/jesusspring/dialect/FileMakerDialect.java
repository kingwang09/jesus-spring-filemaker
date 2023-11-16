package org.jesus.jesusspring.dialect;

import lombok.NoArgsConstructor;
import org.hibernate.LockMode;
import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.identity.HSQLIdentityColumnSupport;
import org.hibernate.dialect.pagination.AbstractLimitHandler;
import org.hibernate.dialect.pagination.LimitHandler;
import org.hibernate.dialect.pagination.OffsetFetchLimitHandler;
import org.hibernate.engine.jdbc.dialect.spi.DialectResolutionInfo;
import org.hibernate.query.spi.Limit;


public class FileMakerDialect extends Dialect {

    public FileMakerDialect(DialectResolutionInfo info) {
        super( info );
    }

    public boolean dropConstraints() {
        return false;
    }

    public boolean hasAlterTable() {
        return false;
    }

    public boolean supportsColumnCheck() {
        return false;
    }

    public boolean supportsCascadeDelete() {
        return false;
    }

    public boolean supportsLockTimeouts() {
        return false;
    }

    public boolean canCreateSchema() {
        return false;
    }

    public String getCurrentTimestampSQLFunctionName() {
        return "current_timestamp";
    }

    public boolean isCurrentTimestampSelectStringCallable() {
        return false;
    }

    public boolean supportsCurrentTimestampSelection() {
        return true;
    }

    public boolean supportsOuterJoinForUpdate() {
        return false;
    }

    public boolean supportsTableCheck() {
        return false;
    }

    public boolean supportsUnionAll() {
        return false;
    }

    public boolean supportsUnique() {
        return false;
    }

    public String toBooleanValueString(boolean arg0) {
        if (arg0) {
            return "{b'true'}";
        }
        return "{b'false'}";
    }

    public String getForUpdateNowaitString() {
        return "";
    }

    public String getForUpdateNowaitString(String aliases) {
        return "";
    }

    public String getForUpdateString() {
        return "";
    }

    public String getForUpdateString(LockMode lockMode) {
        return "";
    }

    public String getForUpdateString(String aliases) {
        return "";
    }

//    @Override
//    public LimitHandler getLimitHandler() {
//        return new AbstractLimitHandler() {
//            @Override
//            public boolean supportsLimit() {
//                return true;
//            }
//
//            @Override
//            public String processSql(String sql, Limit selection) {
//                String soff = String.format(" offset %d rows /*?*/", selection.getFirstRow());
//                String slim = String.format(" fetch first %d rows only /*?*/", selection.getMaxRows());
//                StringBuilder sb = (new StringBuilder(sql.length() + soff.length() + slim.length())).append(sql);
//
//                if (LimitHelper.hasFirstRow(selection)) {
//                    sb.append(soff);
//                }
//
//                if (LimitHelper.hasMaxRows(selection)) {
//                    sb.append(slim);
//                }
//
//                return sb.toString();
//            }
//        };
//    }

}
