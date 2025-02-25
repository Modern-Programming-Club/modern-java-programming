package com.mpc.springboot.config.persistence.jpa;

import org.hibernate.boot.model.naming.CamelCaseToUnderscoresNamingStrategy;
import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

public class QuotedCamelCaseToUnderScoresNamingStrategy extends CamelCaseToUnderscoresNamingStrategy {

    @Override
    public Identifier toPhysicalColumnName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        if (name == null) {
            return null;
        }
        Identifier snakeCaseIdentifier = super.toPhysicalColumnName(name, jdbcEnvironment);
        return Identifier.toIdentifier("`" + snakeCaseIdentifier.getText() + "`", snakeCaseIdentifier.isQuoted());
    }

    @Override
    public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment jdbcEnvironment) {
        if (name == null) {
            return null;
        }
        Identifier snakeCaseIdentifier = super.toPhysicalTableName(name, jdbcEnvironment);
        return Identifier.toIdentifier("`" + snakeCaseIdentifier.getText() + "`", snakeCaseIdentifier.isQuoted());
    }
}
