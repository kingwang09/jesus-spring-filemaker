package org.jesus.jesusspring.dialect;

import lombok.NoArgsConstructor;
import org.hibernate.LockMode;
import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.identity.HSQLIdentityColumnSupport;
import org.hibernate.engine.jdbc.dialect.spi.DialectResolutionInfo;


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

}
