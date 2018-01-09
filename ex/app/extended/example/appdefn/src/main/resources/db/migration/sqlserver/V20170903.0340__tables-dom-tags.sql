SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO


CREATE TABLE [isistags].[Tag](
	[id] [bigint] IDENTITY(1,1) NOT NULL,
	[key] [varchar](50) NOT NULL,
	[taggedIdentifier] [varchar](254) NOT NULL,
	[taggedObjectType] [varchar](254) NOT NULL,
	[value] [varchar](128) NOT NULL,
	[version] [bigint] NOT NULL,
 CONSTRAINT [Tag_PK] PRIMARY KEY CLUSTERED
(
	[id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY],
 CONSTRAINT [Tag_taggedObject_key_UNQ] UNIQUE NONCLUSTERED
(
	[taggedObjectType] ASC,
	[key] ASC,
	[taggedIdentifier] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

