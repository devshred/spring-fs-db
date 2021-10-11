package org.devshred.sqlite

import org.hibernate.dialect.Dialect
import org.hibernate.dialect.function.SQLFunctionTemplate
import org.hibernate.dialect.function.StandardSQLFunction
import org.hibernate.dialect.function.VarArgsSQLFunction
import org.hibernate.type.StringType
import java.sql.Types


class SQLiteDialect : Dialect() {
    init {
        registerColumnType(Types.BIT, "integer")
        registerColumnType(Types.TINYINT, "tinyint")
        registerColumnType(Types.SMALLINT, "smallint")
        registerColumnType(Types.INTEGER, "integer")
        registerColumnType(Types.BIGINT, "bigint")
        registerColumnType(Types.FLOAT, "float")
        registerColumnType(Types.REAL, "real")
        registerColumnType(Types.DOUBLE, "double")
        registerColumnType(Types.NUMERIC, "numeric")
        registerColumnType(Types.DECIMAL, "decimal")
        registerColumnType(Types.CHAR, "char")
        registerColumnType(Types.VARCHAR, "varchar")
        registerColumnType(Types.LONGVARCHAR, "longvarchar")
        registerColumnType(Types.DATE, "date")
        registerColumnType(Types.TIME, "time")
        registerColumnType(Types.TIMESTAMP, "timestamp")
        registerColumnType(Types.BINARY, "blob")
        registerColumnType(Types.VARBINARY, "blob")
        registerColumnType(Types.LONGVARBINARY, "blob")
        registerColumnType(Types.NULL, "null");
        registerColumnType(Types.BLOB, "blob")
        registerColumnType(Types.CLOB, "clob")
        registerColumnType(Types.BOOLEAN, "integer")
        registerFunction("concat", VarArgsSQLFunction(StringType.INSTANCE, "", "||", ""))
        registerFunction("mod", SQLFunctionTemplate(StringType.INSTANCE, "?1 % ?2"))
        registerFunction("substr", StandardSQLFunction("substr", StringType.INSTANCE))
        registerFunction("substring", StandardSQLFunction("substr", StringType.INSTANCE))
    }

    fun supportsIdentityColumns() = true
    fun hasDataTypeInIdentityColumn() = false
    val identityColumnString = "integer"
    val identitySelectString = "select last_insert_rowid()"

    override fun supportsLimit() = true
    override fun getLimitString(query: String, hasOffset: Boolean) =
        query + if (hasOffset) " limit ? offset ?" else " limit ?"

    fun supportsTemporaryTables() = true
    val createTemporaryTableString = "create temporary table if not exists"
    fun dropTemporaryTableAfterUse() = false

    override fun supportsCurrentTimestampSelection() = true
    override fun isCurrentTimestampSelectStringCallable() = false
    override fun getCurrentTimestampSelectString() = "select current_timestamp"
    override fun supportsUnionAll() = true
    override fun hasAlterTable() = false
    override fun dropConstraints() = false
    override fun getAddColumnString() = "add column"
    override fun getForUpdateString() = ""
    override fun supportsOuterJoinForUpdate() = false
    override fun supportsIfExistsBeforeTableName() = true
    override fun supportsCascadeDelete() = false

    override fun getDropForeignKeyString(): String {
        throw UnsupportedOperationException("Drop foreign key not supported by SQLiteDialect.")
    }

    override fun getAddForeignKeyConstraintString(
        constraintName: String,
        foreignKey: Array<String>,
        referencedTable: String,
        primaryKey: Array<String>,
        referencesPrimaryKey: Boolean
    ): String {
        throw UnsupportedOperationException("Add foreign key not supported by SQLiteDialect.")
    }

    override fun getAddPrimaryKeyConstraintString(constraintName: String): String {
        throw UnsupportedOperationException("Add primary key not supported by SQLiteDialect.")
    }
}